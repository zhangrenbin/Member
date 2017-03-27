package com.ice.sh1.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ice.sh1.dao.MenuMapper;
import com.ice.sh1.po.Menu;
import com.ice.sh1.po.MenuExample;
import com.ice.sh1.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	@Resource
	MenuMapper menuMapper;

	public List<Menu> querySubMenu(int pid) {
		MenuExample me = new MenuExample();
		me.createCriteria().andPIdEqualTo(pid);
		me.setOrderByClause("show_order asc");
		List<Menu> menuList = menuMapper.selectByExample(me);
		return menuList;

	}

	public List<Menu> queryMenuTree(int pid) {
		MenuExample me = new MenuExample();
		me.createCriteria().andPIdEqualTo(pid);
		me.setOrderByClause("show_order asc");
		List<Menu> menuList = menuMapper.selectByExample(me);
		for (Menu fMenu : menuList) {
			List<Menu> list = getMenuTree(fMenu);
			fMenu.setSubMenu(list);
		}
		return menuList;
	}

	private List<Menu> getMenuTree(Menu menu) {
		List<Menu> subMenus = querySubMenu(menu.getId());
		if (subMenus == null || subMenus.size() == 0) {
			return null;
		} else {
			menu.setSubMenu(subMenus);
			for (Menu m : subMenus) {
				getMenuTree(m);
			}
			return subMenus;
		}
	}
	
	private List<Menu> getMenuTree(Menu menu, List<String> allowCodes) {
		List<Menu> subMenus = querySubMenu(menu.getId(), allowCodes);
		if (subMenus == null || subMenus.size() == 0) {
			return null;
		} else {
			menu.setSubMenu(subMenus);
			for (Menu m : subMenus) {
				getMenuTree(m, allowCodes);
			}
			return subMenus;
		}
	}

	// 获取 单个信息
	public Menu queryMenuInfo(int id) {
		return menuMapper.selectByPrimaryKey(id);
	}

	public int addMenu(Menu menu) {
		int maxindex = getMaxIndexByPid(menu.getpId());
		menu.setShowOrder(maxindex + 1);
		int level = getMyLevel(menu.getpId());
		menu.setMenuLevel("" + level);
		menuMapper.insertSelective(menu);
		return menu.getId();
	}
	
	private int getMyLevel(int pid) {
		if(pid <= 0) {
			return 0;
		}
		Menu menu = queryMenuInfo(pid);
		if(menu == null) {
			return 0;
		}
		return Integer.parseInt(menu.getMenuLevel()) + 1;
	}

	public boolean modMenu(Menu menu) {
		menuMapper.updateByPrimaryKeySelective(menu);
		return true;
	}
	
	public boolean delMenu(int id) {
		menuMapper.deleteByPrimaryKey(id);
		return true;
	}

	public int getMaxIndexByPid(int pid) {
		return menuMapper.getMaxIndexByPid(pid);
	}

	public List<Menu> querySubMenu(int pid, List<String> allowCodes) {
		if(allowCodes == null) {
			return querySubMenu(pid);
		}
		if(allowCodes.isEmpty()) {
			return new ArrayList<Menu>();
		}
		MenuExample me = new MenuExample();
		me.createCriteria().andPIdEqualTo(pid).andMenuCodeIn(allowCodes);
		me.setOrderByClause("show_order asc");
		List<Menu> menuList = menuMapper.selectByExample(me);
		return menuList;
	}

	public List<Menu> queryMenuTree(int pid, List<String> allowCodes) {
		if(allowCodes == null) {
			return queryMenuTree(pid);
		}
		if(allowCodes.isEmpty()) {
			return new ArrayList<Menu>();
		}
		MenuExample me = new MenuExample();
		me.createCriteria().andPIdEqualTo(pid).andMenuCodeIn(allowCodes);
		me.setOrderByClause("show_order asc");
		List<Menu> menuList = menuMapper.selectByExample(me);
		for (Menu fMenu : menuList) {
			List<Menu> list = getMenuTree(fMenu, allowCodes);
			fMenu.setSubMenu(list);
		}
		return menuList;
	}
}
