package com.ice.sh1.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ice.sh1.dao.MembTreeMapper;
import com.ice.sh1.po.MembTree;
import com.ice.sh1.service.MembTreeService;

@Service("membTreeService")
@Transactional
public class MembTreeServiceImpl implements MembTreeService {

	@Resource
	private MembTreeMapper membTreeMapper;
	
	public MembTree get(int id) {
		return membTreeMapper.getById(id);
	}

	public List<MembTree> getByPid(int pid) {
		return membTreeMapper.getByPId(pid);
	}

	public boolean delete(int id) {
		membTreeMapper.deleteById(id);
		return true;
	}

	public int add(MembTree m) {
		membTreeMapper.insertSelective(m);
		return m.getId();
	}
	
	public MembTree getTreeByMembIdNoParent(int membid) {
		MembTree mt = membTreeMapper.getByMembId(membid);
		if(mt == null) {
			return null;
		}
		List<MembTree> cl = getChild(mt.getId(), false);
		for (MembTree mtt : cl) {
			if("L".equals(mtt.getPos())) {
				mt.setLeftChild(mtt);
			} else {
				mt.setRightChild(mtt);
			}
		}
		return mt;
	}

	public MembTree getTreeByMembId(int membid) {
		MembTree mt = membTreeMapper.getByMembId(membid);
		if(mt == null) {
			return null;
		}
		List<MembTree> cl = getChild(mt.getId(),false);
		for (MembTree mtt : cl) {
			mtt.setParent(mt);
			if("L".equals(mtt.getPos())) {
				mt.setLeftChild(mtt);
			} else {
				mt.setRightChild(mtt);
			}
		}
		return mt;
	}
	
	private List<MembTree> getChild(int id, boolean setParent) {
		List<MembTree> l = membTreeMapper.getByPId(id);
		for (MembTree mt : l) {
			List<MembTree> cl = getChild(mt.getId(), setParent);
			for (MembTree mtt : cl) {
				if(setParent) {
					mtt.setParent(mt);
				}
				if("L".equals(mtt.getPos())) {
					mt.setLeftChild(mtt);
				} else {
					mt.setRightChild(mtt);
				}
			}
		}
		return l;
	}

}
