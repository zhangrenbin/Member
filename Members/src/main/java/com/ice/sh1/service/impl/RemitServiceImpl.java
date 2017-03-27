package com.ice.sh1.service.impl;

import ice.tool.Page;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ice.sh1.dao.RemitsMapper;
import com.ice.sh1.po.Member;
import com.ice.sh1.po.Remits;
import com.ice.sh1.po.RemitsExample;
import com.ice.sh1.service.MembService;
import com.ice.sh1.service.RemitService;
import com.ice.task.MoneyTask;
import com.ice.task.TaskEvent;

@Service("remitService")
@Transactional
public class RemitServiceImpl implements RemitService {

	@Resource
	private RemitsMapper remitsMapper;
	
	@Resource
	private MembService membService;
	
	public int subRemit(Remits r) {
		if(r.getrBdmemb() == null) {
			r.setrBdmemb(0);
		}
		r.setrState(0);
		r.setrSubDate(new Date());
		remitsMapper.insertSelective(r);
		return r.getId();
	}

	public List<Remits> getRemitsByMemb(int memb) {
		RemitsExample re = new RemitsExample();
		re.createCriteria().andRFromUserEqualTo(memb);
		List<Remits> l = remitsMapper.selectByExample(re);
		translateMemb(l);
		return l;
	}

	public List<Remits> queryRemits(RemitsExample re) {
		List<Remits> l = remitsMapper.selectByExample(re);
		translateMemb(l);
		return l;
	}

	public Page<Remits> queryRemitsPage(RemitsExample re) {
		int cnt = remitsMapper.countByExample(re);
		List<Remits> l = remitsMapper.selectByExample(re);
		translateMemb(l);
		Page<Remits> p = new Page<Remits>(l,re.getStart(),re.getSize(),cnt);
		return p;
	}
	
	private void translateMemb(List<Remits> l) {
		for(Remits r : l) {
			Member m = membService.get(r.getrFromUser());
			if(m == null) {
				continue;
			}
			r.addExtendPro("membName", m.getmCnname());
			r.addExtendPro("membAccount", m.getmAccount());
			r.addExtendPro("membActive", m.getmActive());
		}
	}

	public void confirmRemit(int id, String admin) {
		Remits r = new Remits();
		r.setrAdmin(admin);
		r.setrState(1);
		r.setId(id);
		remitsMapper.updateByPrimaryKeySelective(r);
		//触发奖励规则
		TaskEvent te = TaskEvent.REMIT_EVENT;
		te.setRemits(r);
		MoneyTask.addEvent(te);
	}

	public void rejectRemit(int id, String admin) {
		Remits r = new Remits();
		r.setrAdmin(admin);
		r.setrState(-1);
		r.setId(id);
		remitsMapper.updateByPrimaryKeySelective(r);
	}

	public Remits getRemits(int id) {
		Remits r = remitsMapper.selectByPrimaryKey(id);
		translateMemb(r);
		return r;
	}
	
	private void translateMemb(Remits r) {
		Member m = membService.get(r.getrFromUser());
		if(m == null) {
			return;
		}
		r.addExtendPro("membName", m.getmCnname());
		r.addExtendPro("membAccount", m.getmAccount());
		r.addExtendPro("membActive", m.getmActive());
	}

	public Page<Remits> getRemitsPageByMemb(int start, int size, int memb) {
		RemitsExample re = new RemitsExample();
		re.createCriteria().andRFromUserEqualTo(memb);
		re.setStart(start);
		re.setSize(size);
		int cnt = remitsMapper.countByExample(re);
		List<Remits> l = remitsMapper.selectByExample(re);
		translateMemb(l);
		Page<Remits> p = new Page<Remits>(l,re.getStart(),re.getSize(),cnt);
		return p;
	}

}
