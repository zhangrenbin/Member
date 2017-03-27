package com.ice.sh1.service;

import java.util.List;

import com.ice.sh1.po.MembTree;

public interface MembTreeService {

	public MembTree get(int id);
	
	public List<MembTree> getByPid(int pid);
	
	public boolean delete(int id);
	
	public int add(MembTree m);
	
	public MembTree getTreeByMembId(int membid);
	
	public MembTree getTreeByMembIdNoParent(int membid);
}
