package com.ice.rule.impl;

import org.springframework.web.context.ContextLoader;

import com.ice.rule.BonusComputer;
import com.ice.sh1.po.BonusRecord;
import com.ice.sh1.po.BonusRule;
import com.ice.sh1.po.Remits;
import com.ice.sh1.service.BonusRecordService;

public class BdRule implements BonusComputer {
	
	private BonusRecordService bonusRecordService;
	
	private BonusRule rule;

	public void compute(Object o) {
		if(!(o instanceof Remits)) {
			return;
		}
		Remits my = (Remits)o;
		if(my.getrBdmemb() == null || my.getrBdmemb()  == 0) {
			return;
		}
		if(bonusRecordService == null) {
			bonusRecordService = (BonusRecordService)ContextLoader.
					getCurrentWebApplicationContext().getBean("bonusRecordService");
		}
		BonusRecord br = new BonusRecord();
		br.setrDesc("报单奖励");
		br.setrMember(my.getrBdmemb());
		br.setrMoney(rule.getrBonus());
		br.setrRule(rule.getId());
		br.setrPoint("0");
		bonusRecordService.add(br);
	}

	public void setRule(BonusRule rule) {
		this.rule = rule;
	}

}
