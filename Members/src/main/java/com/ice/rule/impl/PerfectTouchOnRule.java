package com.ice.rule.impl;

import org.springframework.web.context.ContextLoader;

import com.ice.rule.BonusComputer;
import com.ice.sh1.po.BonusRecord;
import com.ice.sh1.po.BonusRule;
import com.ice.sh1.po.MembTree;
import com.ice.sh1.service.BonusRecordService;

public class PerfectTouchOnRule implements BonusComputer{

	private BonusRecordService bonusRecordService;
	
	private BonusRule rule;
	
	public void compute(Object o) {
		if(!(o instanceof MembTree)) {
			return;
		}
		MembTree my = (MembTree)o;
		int recommer = my.getRecommer();
		int level = 1;
		MembTree p = my.getParent();
		while(p != null && p.getMembId() != recommer) {
			p = p.getParent();
			level++;
		}
		if(p == null) {
			return;
		}
		//获取指定层级直推的会员数，分左右区
		int leftNum = getLevelMyChildren(p.getLeftChild(), level - 1, recommer);
		int rightNum = getLevelMyChildren(p.getRightChild(), level - 1, recommer);
		if((leftNum == rightNum) && rightNum != 0) {
			//排除已经满足小区碰对的情况
			if(isHalfTunchOn(my)) {
				return;
			}
			//判断直推的数目达到1:1,满足奖励条件
			if(bonusRecordService == null) {
				bonusRecordService = (BonusRecordService)ContextLoader.
						getCurrentWebApplicationContext().getBean("bonusRecordService");
			}
			BonusRecord br = new BonusRecord();
			br.setrDesc("大区碰对");
			br.setrMember(recommer);
			br.setrMoney(rule.getrBonus());
			br.setrRule(rule.getId());
			br.setrPoint("0");
			bonusRecordService.add(br);
		}
	}
	
	private boolean isHalfTunchOn(MembTree my) {
//		MembTree p = my.getParent();
//		if(p == null) {
//			return false;
//		}
//		MembTree lt = p.getLeftChild();
//		MembTree rt = p.getRightChild();
//		if(lt != null && rt != null && lt.getRecommer() != rt.getRecommer()) {
//			return true;
//		}
		return false;
	}
	
	private int getLevelMyChildren(MembTree top, int level, int recommer) {
		int num = 0;
		if(top == null) {
			return 0;
		}
		if(level < 1) {
			if(top.getRecommer() == recommer) {
				num++;
			}
		} else {
			num += getLevelMyChildren(top.getLeftChild(),level - 1, recommer);
			num += getLevelMyChildren(top.getRightChild(),level - 1, recommer);
		}
		return num;
	}

	public void setRule(BonusRule rule) {
		this.rule = rule;
	}

}
