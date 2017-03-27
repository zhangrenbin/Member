package com.ice.sh1;

import ice.tool.PropertiesProvider;
import ice.tool.validation.StringValidator;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ice.sh1.action.BaseAction;
import com.ice.sh1.po.Member;
import com.ice.sh1.service.MembService;
import com.inspur.guarder.pojo.Function;
import com.inspur.guarder.pojo.Group;
import com.inspur.guarder.pojo.User;

public class AfterLoginFilter extends BaseAction implements Filter {
	
	private String god_group = "memb_admin";
	
	public void destroy() {
		
	}

	public void doFilter(ServletRequest req_, ServletResponse resp_,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletResponse resp = (HttpServletResponse)resp_;
		HttpServletRequest req = (HttpServletRequest)req_;
		//初始化member
		if(!initMember(req, resp)) {
			return;
		}
		//判断接口的调用权限
		if(!authUri(req, resp)) {
			return;
		}
		arg2.doFilter(req, resp);
	}
	
	private boolean authUri(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException, ServletException {
		String uri = req.getRequestURI();
		String fpath = "";
		Matcher m = Pattern.compile(".*/f_(.+)?/").matcher(uri);
		if(m.find()) {
			fpath = m.group(1);
		}
		if(StringValidator.isEmpty(fpath)) {
			m = Pattern.compile(".*/f_(.+)?\\.").matcher(uri);
			if(m.find()) {
				fpath = m.group(1);
			}
		}
		if(StringValidator.isEmpty(fpath)) {
			return true;
		}
		//验证权限
		if(validateAuth(fpath, req, resp)) {
			return true;
		}
		return false;
	}
	
	private boolean validateAuth(String func, HttpServletRequest req, HttpServletResponse resp) 
			throws IOException, ServletException {
		User u = getMyUser(req);
		List<Function> fl = u.getFuncList();
		for (Function f : fl) {
			if(func.equals(f.getfCode())) {
				return true;
			}
		}
		req.getSession().invalidate();
		req.setAttribute("msg", "您无权访问此页面！");
		req.getRequestDispatcher("/jsp/error.jsp").forward(req, resp);
		return false;
	}
	
	private boolean initMember(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException, ServletException {
		if(getMyMemb(req) != null) {
			return true;
		}
		if(getMyUser(req) == null) {
			return false;
		}
		//查询member
		ApplicationContext ac =
				WebApplicationContextUtils.getWebApplicationContext(req.getServletContext());
		MembService membService = (MembService)ac.getBean("membService");
		User u = getMyUser(req);
		Member m = membService.getAccount(u.getUserAccount());
		addToSession(req, "mymember", m);
		/*
		//如果未激活，跳转至错误页面
		if(!isActive(req)) {
			req.getSession().invalidate();
			req.setAttribute("msg", "您的账号未激活或不存在！");
			req.getRequestDispatcher("/jsp/error.jsp").forward(req, resp);
			return false;
		}
		*/
		//判断god
		u.setGod(false);
		for (Group g : u.getGroupList()) {
			if(god_group.equals(g.getgCode())) {
				u.setGod(true);
				break;
			}
		}
		return true;
	}

	public void init(FilterConfig c) throws ServletException {
		PropertiesProvider pp = PropertiesProvider.getInstance("/ice.properties");
		god_group = pp.getValue("god_group");
	}

	public static void main(String[] args) {
		Matcher m = Pattern.compile(".*/f_(.+)?/").matcher("s/f_aa/a.do");
		if(m.find()) {
			System.out.println(m.group(1));
		}
	}
}
