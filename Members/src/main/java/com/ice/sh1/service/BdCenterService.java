package com.ice.sh1.service;

import java.util.List;

import com.ice.sh1.po.BdCenter;
import com.ice.sh1.po.BdCenterExample;

import ice.tool.Page;

public interface BdCenterService {

	public int add(BdCenter bd);
	
	public List<BdCenter>  queryList(BdCenterExample be);
	
	public Page<BdCenter>  queryPage(BdCenterExample be);
	
	public boolean ok(int id);
	
	public boolean reject(int id);
	
	public BdCenter get(int id);
	
	public BdCenter getByMemb(int mid);
}
