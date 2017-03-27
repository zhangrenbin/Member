package com.ice.sh1.action;

import ice.tool.GsonUtil;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ice.sh1.po.Menu;
import com.ice.sh1.service.MenuService;
import com.inspur.guarder.pojo.Function;
import com.inspur.guarder.pojo.User;

@Controller
@RequestMapping("/menu")
public class MenuAction extends BaseAction {

	@Resource
	MenuService menuService;
	
	@RequestMapping("/menuPage")
	public ModelAndView menuPage(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("menu/menuManage");
		return mv;
	}

	@RequestMapping("/queryMenuTree")
	public void queryMenuTree(HttpServletRequest req, HttpServletResponse resp) {
		String useToManage = getStringParam(req, "useToManage");
		List<String> al = getMyAllowCodes(req);
		int pid = -1;
		List<Menu> list = menuService.queryMenuTree(pid, al);
		if("true".equals(useToManage)) {
			//添加一个根节点
			Menu froot = getRoot();
			froot.setSubMenu(list);
			list = new ArrayList<Menu>();
			list.add(froot);
		}
		String json= GsonUtil.ObjToString(list, null);
		outBack(resp, json, "json");
	}
	
	private List<String> getMyAllowCodes(HttpServletRequest req) {
		User u = getMyUser(req);
		List<String> l = new ArrayList<String>();
		for (Function f : u.getFuncList()) {
			l.add(f.getfCode());
		}
		return l;
	}
	
	@RequestMapping("/menuTree")
	public String menuTree(HttpServletRequest req) {
		int pid = -1;
		List<Menu> list = menuService.queryMenuTree(pid);
		req.setAttribute("menu", list);
		return "frame/fragment/left_sub";

	}

	@RequestMapping("/modMenu")
	public void modMenu(HttpServletResponse resp, Menu menu) {
		boolean b = menuService.modMenu(menu);
		if(b) {
			outBack(resp, getFeedJson("true", "成功"), "json");
			return;
		} 
		outBack(resp, getFeedJson("false", "失败"), "json");
	}
	
	@RequestMapping("/delMenu")
	public void delMenu(HttpServletResponse resp, int id) {
		boolean b = menuService.delMenu(id);
		if(b) {
			outBack(resp, getFeedJson("true", "成功"), "json");
			return;
		} 
		outBack(resp, getFeedJson("false", "失败"), "json");
	}
	
	@RequestMapping("/addMenu")
	public void addMenu(HttpServletResponse resp, Menu menu) {
		int id = menuService.addMenu(menu);
		if(id > 0) {
			outBack(resp, getFeedJson("true", "成功"), "json");
			return;
		} 
		outBack(resp, getFeedJson("false", "失败"), "json");
	}

	@RequestMapping("/queryMenuInfo")
	public void queryMenuInfo(HttpServletRequest req, HttpServletResponse resp, @RequestParam int menuId) {
		if(menuId == -1) {
			outBack(resp, GsonUtil.ObjToString(getRoot(), null), "json");
			return;
		}
		Menu m = menuService.queryMenuInfo(menuId);
		outBack(resp, GsonUtil.ObjToString(m, null), "json");
	}
	
	@RequestMapping("/modOrder")
	public void modOrder(HttpServletRequest req, HttpServletResponse resp) {
		int myid = getIntParam(req, "myid");
		int swapid = getIntParam(req, "swapid");
		Menu my = menuService.queryMenuInfo(myid);
		Menu swap = menuService.queryMenuInfo(swapid);
		int tmp = my.getShowOrder();
		my.setShowOrder(swap.getShowOrder());
		swap.setShowOrder(tmp);
		menuService.modMenu(my);
		menuService.modMenu(swap);
		outBack(resp, getFeedJson("true", "成功"), "json");
	}
	
	private Menu getRoot() {
		Menu froot = new Menu();
		froot.setId(-1);
		froot.setImg("fa-bars");
		froot.setMenuName("菜单树");
		froot.setMenuCode("");
		froot.setMenuLevel("-1");
		return froot;
	}
}
