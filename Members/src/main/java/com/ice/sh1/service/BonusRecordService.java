package com.ice.sh1.service;

import ice.tool.Page;

import java.util.List;

import com.ice.sh1.po.BonusRecord;
import com.ice.sh1.po.BonusRecordExample;

public interface BonusRecordService {

	public int add(BonusRecord br);
	
	public BonusRecord get(int id);
	
	public List<BonusRecord> queryList(BonusRecordExample be);
	
	public Page<BonusRecord> queryPage(BonusRecordExample be);
	
	public boolean baodan(int id);
	
	public boolean chuli(int id);
}
