package com.ice.sh1.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ice.sh1.dao.BdCenterMapper;
import com.ice.sh1.po.BdCenter;
import com.ice.sh1.po.BdCenterExample;
import com.ice.sh1.service.BdCenterService;

import ice.tool.Page;

@Service("bdCenterService")
@Transactional
public class BdCenterServiceImpl implements BdCenterService {
	
	@Resource
	private BdCenterMapper bdCenterMapper;

	public int add(BdCenter bd) {
		BdCenter obd = getByMemb(bd.getmId());
		if(obd != null && obd.getbState() > -1) {
			//���ڼ�¼�����ܽ������
			return 0;
		}
		bd.setbDate(new Date());
		bd.setbState(0);
		bdCenterMapper.insertSelective(bd);
		return bd.getId();
	}

	public List<BdCenter> queryList(BdCenterExample be) {
		return bdCenterMapper.selectByExample(be);
	}

	public Page<BdCenter> queryPage(BdCenterExample be) {
		List<BdCenter> l = bdCenterMapper.selectByExample(be);
		int cnt = bdCenterMapper.countByExample(be);
		return new Page<BdCenter>(l, be.getStart(), be.getSize(), cnt);
	}

	public boolean ok(int id) {
		BdCenter bd = get(id);
		if(bd.getbState() != 0) {
			return false;
		}
		bd.setbState(1);
		bd.setbApproveDate(new Date());
		bdCenterMapper.updateByPrimaryKeySelective(bd);
		return true;
	}

	public boolean reject(int id) {
		BdCenter bd = get(id);
		if(bd.getbState() != 0) {
			return false;
		}
		bd.setbState(-1);
		bd.setbApproveDate(new Date());
		bdCenterMapper.updateByPrimaryKeySelective(bd);
		return true;
	}

	public BdCenter get(int id) {
		return bdCenterMapper.selectByPrimaryKey(id);
	}

	public BdCenter getByMemb(int mid) {
		BdCenterExample be = new BdCenterExample();
		be.setOrderByClause("b_date desc");
		be.createCriteria().andMIdEqualTo(mid);
		List<BdCenter> l =queryList(be);
		if(!l.isEmpty()) {
			return l.get(0);
		}
		return null;
	}

}
