package com.ice.sh1.service;

import ice.tool.Page;

import java.util.List;

import com.ice.sh1.po.Remits;
import com.ice.sh1.po.RemitsExample;

public interface RemitService {

	public int subRemit(Remits r);
	
	public List<Remits> getRemitsByMemb(int memb);
	
	public Page<Remits> getRemitsPageByMemb(int start, int size, int memb);
	
	public List<Remits> queryRemits(RemitsExample re);
	
	public Page<Remits> queryRemitsPage(RemitsExample re);
	
	public void confirmRemit(int id, String admin);
	
	public void rejectRemit(int id, String admin);
	
	public Remits getRemits(int id);
}
