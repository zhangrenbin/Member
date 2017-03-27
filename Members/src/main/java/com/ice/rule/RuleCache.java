package com.ice.rule;

import java.util.List;

import javax.annotation.Resource;

import com.ice.sh1.dao.BonusRuleMapper;
import com.ice.sh1.po.BonusRule;
import com.ice.sh1.po.BonusRuleExample;

public class RuleCache {

	private static RuleCache intance;
	
	public static RuleCache getInstance() {
		if(intance == null) {
			intance = new RuleCache();
		}
		return intance;
	}
	
	private List<BonusRule> list;
	
	public RuleCache() {
		
	}
	
	@Resource
	private BonusRuleMapper bonusRuleMapper;
	
	public List<BonusRule> getRuleList() {
		if(list == null || list.isEmpty()) {
			BonusRuleExample re = new BonusRuleExample();
			re.createCriteria().andREnableGreaterThan(0);
			re.setOrderByClause("id asc");
			list = bonusRuleMapper.selectByExample(re);
			for (BonusRule r : list) {
				try {
					r.setComputer((BonusComputer)Class.forName(r.getrClass()).newInstance());
					r.getComputer().setRule(r);
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;
	}
}
