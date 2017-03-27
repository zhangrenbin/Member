package com.ice.rule.impl;

import org.springframework.web.context.ContextLoader;

import com.ice.rule.BonusComputer;
import com.ice.sh1.po.BonusRecord;
import com.ice.sh1.po.BonusRule;
import com.ice.sh1.po.MembTree;
import com.ice.sh1.service.BonusRecordService;

public class HalfTounchOnRule implements BonusComputer {

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
		MembTree p = my.getParent();
		if(p == null) {
			return;
		}
		MembTree lt = p.getLeftChild();
		MembTree rt = p.getRightChild();
		if(lt != null && rt != null && (lt.getRecommer() != rt.getRecommer())) {
			//满足小区碰对
			BonusRecord br = new BonusRecord();
			br.setrDesc("小区碰对");
			br.setrMember(lt.getRecommer());
			br.setrMoney(rule.getrBonus());
			br.setrRule(rule.getId());
			br.setrPoint("0");
			bonusRecordService.add(br);
		}
	}

	public void setRule(BonusRule rule) {
		this.rule = rule;
	}

}
