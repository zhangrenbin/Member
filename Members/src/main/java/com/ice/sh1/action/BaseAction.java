package com.ice.sh1.action;

import ice.tool.GsonUtil;
import ice.tool.Page;
import ice.tool.validation.StringValidator;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import com.ice.sh1.po.Member;
import com.inspur.guarder.client.GuarderClientFilter;
import com.inspur.guarder.pojo.User;

public class BaseAction {
	

	private Logger log = Logger.getLogger(BaseAction.class);
	
	public String getAccount(HttpServletRequest req) {
		User u = (User)req.getSession().getAttribute(GuarderClientFilter.USERINFO);
		if(u == null) {
			//返回默认用户
			return "";
		}
		return u.getUserAccount();
	}
	
	public User getMyUser(HttpServletRequest req) {
		User u = (User)req.getSession().getAttribute(GuarderClientFilter.USERINFO);
		return u;
	}
	
	public int getPageSize(HttpServletRequest req) {
		try {
			int rows = Integer.valueOf(req.getParameter("rows"));
			return rows;
		} catch(Exception e) {
			log.error("未设置pagesize");
		}
		return -1;
	}
	
	public int getPageIndex(HttpServletRequest req) {
		try {
			int page = Integer.valueOf(req.getParameter("page"));
			return page;
		} catch(Exception e) {
			log.error("未设置页面下标");
		}
		return -1;
	}
	
	
	public Map getParamMap(HttpServletRequest req){
         Enumeration<String> e= req.getParameterNames();
	    Map m=new HashMap<String, String>();
	    while(e.hasMoreElements()){
	    	String key=e.nextElement();
	    	String value=req.getParameter(key);
	    	m.put(key, value);
	    }
	    return m;
	}
	
	public void outBack(HttpServletResponse resp, String data, String type) {
		resp.setCharacterEncoding("utf-8");
		if("json".equals(type)) {
			type = "text/json";
		}
		resp.setContentType(type);
		try {
			resp.getWriter().print(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public <T> String pageToJson(Page<T> p) {
		Map<String, Object> result = new HashMap<String, Object>();  
        result.put("total", p.getTotalSize());  
        result.put("rows", p.getResultList()); 
        String json = GsonUtil.ObjToString(result, result.getClass());
		return json;
	}
	
	public int getIntParam(HttpServletRequest req, String param) throws RuntimeException {
		String p = req.getParameter(param);
		if(StringValidator.isEmpty(p)) {
			throw new NumberFormatException("参数为空，无法转为int类型");
		}
		return Integer.parseInt(p);
	}
	
	public String getStringParam(HttpServletRequest req, String param) {
		String p = req.getParameter(param);
		if(StringValidator.isEmpty(p)) {
			return "";
		}
		return p.trim();
	}
	
	protected ModelAndView getErrorModelView(String msg) {
		ModelAndView mv = new ModelAndView("error");
		Map<String,String> map = new HashMap<String, String>();
		map.put("msg", msg);
		mv.addObject("error", map);
		return mv;
	}
	
	/**
	 * 构造ajax回写的 字符串
	 * @param success
	 * @param msg
	 * @return
	 */
	protected String getFeedJson(String success, String msg) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("success", success);
		map.put("msg", msg);
		String json = GsonUtil.ObjToString(map, null);
		return json;
	}
	
	protected void addToSession(HttpServletRequest req, String key, Object o) {
		req.getSession().setAttribute(key, o);
	}
	
	protected <T> T getFromSession(HttpServletRequest req, String key) {
		return (T)req.getSession().getAttribute(key);
	}
	
	public Member getMyMemb(HttpServletRequest req) {
		Member m = (Member)req.getSession().getAttribute("mymember");
		return m;
	}
	
	public boolean isActive(HttpServletRequest req) {
		Member m = getMyMemb(req);
		if(m == null) {
			return false;
		}
		if(m.getmActive() == null || m.getmActive() < 1) {
			return false;
		}
		return true;
	}
	
	public boolean isGod(HttpServletRequest req) {
		User u = getMyUser(req);
		if(u == null) {
			return false;
		}
		if(u.isGod()) {
			return true;
		}
		return false;
	}
	
	public void trace(Object o) {
		System.out.println(o);
	}
}
