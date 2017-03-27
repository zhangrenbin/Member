package com.ice.rule.impl;

import org.springframework.web.context.ContextLoader;

import com.ice.rule.BonusComputer;
import com.ice.sh1.po.BonusRecord;
import com.ice.sh1.po.BonusRule;
import com.ice.sh1.po.MembTree;
import com.ice.sh1.service.BonusRecordService;

public class RecommdRule implements BonusComputer {

	private BonusRecordService bonusRecordService;
	
	private BonusRule rule;
	
	public void compute(Object o) {
		if(!(o instanceof MembTree)) {
			return;
		}
		MembTree my = (MembTree)o;
		if(bonusRecordService == null) {
			bonusRecordService = (BonusRecordService)ContextLoader.
					getCurrentWebApplicationContext().getBean("bonusRecordService");
		}
		//超级管理员直推排除
		if(my.getpId() == 0 || my.getMembId() == 1) {
			return;
		}
		BonusRecord br = new BonusRecord();
		br.setrDesc("会员直推");
		br.setrMember(my.getRecommer());
		br.setrMoney(rule.getrBonus());
		br.setrRule(rule.getId());
		br.setrPoint("0");
		bonusRecordService.add(br);
	}

	public void setRule(BonusRule rule) {
		this.rule = rule;
	}

}
