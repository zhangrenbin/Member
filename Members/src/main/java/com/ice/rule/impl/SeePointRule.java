package com.ice.rule.impl;

import org.springframework.web.context.ContextLoader;

import com.ice.rule.BonusComputer;
import com.ice.sh1.po.BonusRecord;
import com.ice.sh1.po.BonusRule;
import com.ice.sh1.po.MembTree;
import com.ice.sh1.service.BonusRecordService;
import com.ice.sh1.service.MembTreeService;

public class SeePointRule implements BonusComputer {

	private BonusRecordService bonusRecordService;
	
	private MembTreeService membTreeService;
	
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
		if(membTreeService == null) {
			membTreeService = (MembTreeService)ContextLoader.
					getCurrentWebApplicationContext().getBean("membTreeService");
		}
		reward(my.getpId());
	}

	private void reward(int id) {
		MembTree mt = membTreeService.get(id);
		if(mt == null) {
			return;
		}
		BonusRecord br = new BonusRecord();
		br.setrDesc("见点奖励");
		br.setrMember(mt.getMembId());
		br.setrMoney(rule.getrBonus());
		br.setrRule(rule.getId());
		br.setrPoint("0");
		bonusRecordService.add(br);
		reward(mt.getpId());
	}
	
	public void setRule(BonusRule rule) {
		this.rule = rule;
	}
}
