package com.ice.sh1.service;

import ice.tool.Page;

import java.util.List;

import com.ice.sh1.po.WithDraw;
import com.ice.sh1.po.WithDrawExample;

public interface WithDrawService {

	public int add(WithDraw wd);
	
	public boolean ok(int id, String admin);
	
	public boolean reject(int id, String msg, String admin);
	
	public List<WithDraw> queryList(WithDrawExample we);
	
	public Page<WithDraw> queryPage(WithDrawExample we);
	
	public Page<WithDraw> getByMemb(int membid, int page, int rows);
	
	public WithDraw get(int id);
	
	public float getMyLockMoney(int membid);
}
