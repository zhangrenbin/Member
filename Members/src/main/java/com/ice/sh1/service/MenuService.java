package com.ice.sh1.service;

import java.util.List;

import com.ice.sh1.po.Menu;


public interface MenuService {
 
	// 根据父节点查询 
	public List<Menu> querySubMenu(int pid);
	
	// 根据父节点查询 
	public List<Menu> querySubMenu(int pid, List<String> allowCodes);
	
	// 根据根目录id
	public List<Menu> queryMenuTree(int pid);
	
	// 根据根目录id
	public List<Menu> queryMenuTree(int pid, List<String> allowCodes);
	
	// 查询 menu信息
	public Menu queryMenuInfo(int id);
	
	public int addMenu(Menu menu);
	
	public boolean modMenu(Menu menu);
	
	public boolean delMenu(int id);
	
	public int getMaxIndexByPid(int pid);
	
}
