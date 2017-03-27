package com.ice.sh1.service.impl;

import ice.tool.Page;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ice.sh1.dao.BonusRecordMapper;
import com.ice.sh1.po.BonusRecord;
import com.ice.sh1.po.BonusRecordExample;
import com.ice.sh1.service.BonusRecordService;
import com.ice.sh1.service.MembService;

@Service("bonusRecordService")
@Transactional
public class BonusRecordServiceImpl implements BonusRecordService {

	@Resource
	private BonusRecordMapper bonusRecordMapper;
	
	@Resource
	private MembService membService;
	
	public int add(BonusRecord br) {
		br.setrTime(new Date());
		br.setrAddup(1);
		bonusRecordMapper.insertSelective(br);
		//累计总额和余额
		membService.addTotalAndBalance(br.getrMember(), br.getrMoney());
		return br.getId();
	}

	public List<BonusRecord> queryList(BonusRecordExample be) {
		return bonusRecordMapper.selectByExample(be);
	}

	public Page<BonusRecord> queryPage(BonusRecordExample be) {
		int cnt = bonusRecordMapper.countByExample(be);
		List<BonusRecord> l = bonusRecordMapper.selectByExample(be);
		return new Page<BonusRecord>(l,be.getStart(),be.getSize(),cnt);
	}

	public BonusRecord get(int id) {
		return bonusRecordMapper.selectByPrimaryKey(id);
	}

	public boolean baodan(int id) {
		BonusRecord br = bonusRecordMapper.selectByPrimaryKey(id);
		if(br == null || "2".equals(br.getrPoint())) {
			return false;
		}
		br.setrPoint("1");
		bonusRecordMapper.updateByPrimaryKey(br);
		return true;
	}

	public boolean chuli(int id) {
		BonusRecord br = bonusRecordMapper.selectByPrimaryKey(id);
		if(br == null || !"1".equals(br.getrPoint())) {
			return false;
		}
		br.setrPoint("2");
		bonusRecordMapper.updateByPrimaryKey(br);
		return true;
	}

}
