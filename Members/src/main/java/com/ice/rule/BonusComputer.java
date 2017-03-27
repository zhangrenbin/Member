package com.ice.rule;

import com.ice.sh1.po.BonusRule;
import com.ice.sh1.po.MembTree;
import com.ice.sh1.po.Member;

public interface BonusComputer {

	public void compute(Object my);
	
	public void setRule(BonusRule rule);
}
