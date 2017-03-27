package com.ice.sh1.service.impl;

import ice.tool.Page;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ice.sh1.dao.WithDrawMapper;
import com.ice.sh1.po.WithDraw;
import com.ice.sh1.po.WithDrawExample;
import com.ice.sh1.service.MembService;
import com.ice.sh1.service.WithDrawService;

@Service("withDrawService")
@Transactional
public class WithDrawServiceImpl implements WithDrawService {

	@Resource
	private WithDrawMapper withDrawMapper;
	
	@Resource
	private MembService membService;
	
	public int add(WithDraw wd) {
		withDrawMapper.insert(wd);
		return wd.getId();
	}

	public boolean ok(int id, String admin) {
		WithDraw wd = get(id);
		if(wd == null || wd.getState() != 0) {
			return false;
		}
		wd.setState(1);
		wd.setDoAdmin(admin);
		wd.setDoDate(new Date());
		withDrawMapper.updateByPrimaryKeySelective(wd);
		//更新余额
		membService.addDecBalance(wd.getMembId(), wd.getTxMoney());
		return true;
	}

	public boolean reject(int id, String msg, String admin) {
		WithDraw wd = get(id);
		if(wd == null || wd.getState() != 0) {
			return false;
		}
		wd.setState(2);
		wd.setDoAdmin(admin);
		wd.setDoDate(new Date());
		wd.setDoMsg(msg);
		withDrawMapper.updateByPrimaryKeySelective(wd);
		return true;
	}

	public List<WithDraw> queryList(WithDrawExample we) {
		return withDrawMapper.selectByExample(we);
	}

	public Page<WithDraw> queryPage(WithDrawExample we) {
		int cnt = withDrawMapper.countByExample(we);
		List<WithDraw> l = withDrawMapper.selectByExample(we);
		return new Page<WithDraw>(l,we.getStart(),we.getSize(),cnt);
	}

	public Page<WithDraw> getByMemb(int membid, int page, int rows) {
		WithDrawExample we = new WithDrawExample();
		we.createCriteria().andMembIdEqualTo(membid);
		we.setOrderByClause("tx_date desc");
		we.setSize(rows);
		we.setStart((page - 1) * rows);
		List<WithDraw> l = withDrawMapper.selectByExample(we);
		int cnt = withDrawMapper.countByExample(we);
		return new Page<WithDraw>(l,we.getStart(),we.getSize(),cnt);
	}

	public WithDraw get(int id) {
		return withDrawMapper.selectByPrimaryKey(id);
	}

	public float getMyLockMoney(int membid) {
		WithDrawExample we = new WithDrawExample();
		we.createCriteria().andMembIdEqualTo(membid).andStateEqualTo(0);
		List<WithDraw> l = withDrawMapper.selectByExample(we);
		float lock = 0f;
		for (WithDraw w : l) {
			lock += w.getTxMoney();
		}
		return lock;
	}

}
