package com.ice.task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.ice.rule.RuleCache;
import com.ice.sh1.po.BonusRule;
import com.ice.sh1.po.MembTree;
import com.ice.sh1.po.Member;
import com.ice.sh1.po.Remits;
import com.ice.sh1.service.MembTreeService;

public class MoneyTask {
	
	private static MembTreeService membTreeService;

	public static List<TaskEvent> eventList = Collections.synchronizedList(new LinkedList<TaskEvent>());
	
	public static boolean hasStart = false;
	
	public static void addEvent(TaskEvent e) {
		eventList.add(e);
		if(!hasStart) {
			hasStart = true;
			start();
		}
	}
	
	public static void start() {
		new Thread(){
			public void run() {
				while(true) {
					try{
						while(!eventList.isEmpty()) {
							TaskEvent e = eventList.remove(0);
							if(e.isActiveEvent()) {
								//会员激活事件
								MembTree mt = doActive(e.getM());
								doRule(mt);
							} else if(e.isRemitEvent()) {
								//打款
								doRule(e.getRemits());
							}
							
						}
						Thread.sleep(500);
					} catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
	
	private static void doRule(MembTree mt) {
		List<BonusRule> rl = RuleCache.getInstance().getRuleList();
		for (BonusRule bonusRule : rl) {
			bonusRule.getComputer().compute(mt);
		}
	}
	
	private static void doRule(Remits r) {
		List<BonusRule> rl = RuleCache.getInstance().getRuleList();
		for (BonusRule bonusRule : rl) {
			bonusRule.getComputer().compute(r);
		}
	}
	
	public static MembTree doActive(Member m) {
		if(membTreeService == null) {
			WebApplicationContext ac = ContextLoader.getCurrentWebApplicationContext();
			membTreeService = (MembTreeService)ac.getBean("membTreeService");
		}
		MembTree mt = membTreeService.getTreeByMembId(m.getmRecommder());
		//没有顶层，则插入，作为顶层会员
		if(mt == null) {
			mt = new MembTree();
			mt.setpId(0);
			mt.setMembId(m.getId());
			membTreeService.add(mt);
			mt.setParent(null);
			mt = membTreeService.get(mt.getId());
			return mt;
		} 
		return addToTree(mt, m);
	}
	
	private static MembTree addToTree(MembTree mt, Member m) {
		MembTree leftChild = mt.getLeftChild();
		MembTree rightChild = mt.getRightChild();
		MembTree find = null;
		if(leftChild == null || rightChild == null) {
			find = mt;
		} else {
			List<MembTree> l = new ArrayList<MembTree>();
			l.add(leftChild);
			l.add(rightChild);
			find = getMyParent(l);
		}
		if(find == null) {
			mt = new MembTree();
			mt.setpId(0);
			mt.setMembId(m.getId());
			membTreeService.add(mt);
			mt = membTreeService.get(mt.getId());
			mt.setParent(find);
			return mt;
		}
		mt = new MembTree();
		mt.setpId(find.getId());
		mt.setMembId(m.getId());
		if(find.getLeftChild() == null) {
			mt.setPos("L");
		} else {
			mt.setPos("R");
		}
		membTreeService.add(mt);
		mt = membTreeService.get(mt.getId());
		mt.setParent(find);
		if("L".equals(mt.getPos())) {
			find.setLeftChild(mt);
		} else {
			find.setRightChild(mt);
		}
		return mt;
	}
	
	private static MembTree getMyParent(List<MembTree> l) {
		MembTree find = null;
		for (MembTree mt : l) {
			MembTree leftChild = mt.getLeftChild();
			if(leftChild == null) {
				find = mt;
				break;
			}
			MembTree rightChild = mt.getRightChild();
			if(rightChild == null && find == null) {
				find = rightChild;
			}
		}
		if(find != null) {
			return find;
		}
		List<MembTree> l2 = new ArrayList<MembTree>();
		for (MembTree mt : l) {
			l2.add(mt.getLeftChild());
			l2.add(mt.getRightChild());
		}
		return getMyParent(l2);
	}
}
