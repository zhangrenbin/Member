package com.ice.sh1.dao;

import java.util.List;

import com.ice.sh1.po.MembTree;

public interface MembTreeMapper {

	public MembTree getById(int id);
	
	public MembTree getByMembId(int membId);
	
	public List<MembTree> getByPId(int pid);
	
	public int deleteById(int id);
	
	public int insertSelective(MembTree m);
}
