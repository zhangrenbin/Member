package com.ice.sh1.service.impl;

import ice.tool.Page;
import ice.tool.PropertiesProvider;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ice.sh1.dao.MemberMapper;
import com.ice.sh1.po.Member;
import com.ice.sh1.po.MemberExample;
import com.ice.sh1.service.MembService;
import com.ice.task.MoneyTask;
import com.ice.task.TaskEvent;
import com.ice.utils.EncodeUtil;
import com.inspur.guarder.client.api.GroupProxy;
import com.inspur.guarder.client.api.UserProxy;
import com.inspur.guarder.pojo.User;

@Service("membService")
@Transactional
public class MembServiceImpl implements MembService {

	@Resource
	private MemberMapper memberMapper;
	
	PropertiesProvider pp = PropertiesProvider.getInstance("/ice.properties");
	
	public int add(Member m) {
		//加密密码
		m.setmPassword(EncodeUtil.md5AndBase64(m.getmPassword()));
		m.setmActive(0);
		m.setLevel(1);
		m.setmRegdate(new Date());
		m.setmBalance(0f);
		m.setmTotal(0f);
		
		UserProxy up = new UserProxy();
		User u = new User();
		u.setUserAccount(m.getmAccount());
		u.setUserPassword(m.getmPassword());
		u.setName(m.getmCnname());
		try {
			Map<String, String> res = up.addUser(u);
			if("true".equals(res.get("success"))) {
				memberMapper.insertSelective(m);
				//赋予普通会员角色
				GroupProxy gp = new GroupProxy();
				String comm_group = pp.getValue("comm_group");
				gp.addUserToGroup(m.getmAccount(), comm_group);
				return m.getId();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	private void filterPwd(Member m) {
		m.setmPassword("");
		m.setmPassword2("");
	}
	
	private void filterPwd(List<Member> l) {
		for (Member m : l) {
			m.setmPassword("");
			m.setmPassword2("");
		}
	}

	public Member get(int id) {
		Member m = memberMapper.selectByPrimaryKey(id);
		//过滤密码
		filterPwd(m);
		return m;
	}

	public List<Member> queryList(MemberExample me) {
		List<Member> l = memberMapper.selectByExample(me);
		//过滤密码
		filterPwd(l);
		return l;
	}

	public Page<Member> queryPage(MemberExample me) {
		int cnt = memberMapper.countByExample(me);
		List<Member> l = memberMapper.selectByExample(me);
		//过滤密码
		filterPwd(l);
		Page<Member> p = new Page<Member>(l, me.getStart(), me.getSize(), cnt);
		return p;
	}

	public boolean delete(int id) {
		Member m = get(id);
		memberMapper.deleteByPrimaryKey(id);
		if(m != null) {
			//从guarder库删除
			UserProxy up = new UserProxy();
			up.delUser(m.getmAccount());
		}
		return true;
	}

	public boolean deleteByAccount(String account) {
		MemberExample me = new MemberExample();
		me.createCriteria().andMAccountEqualTo(account);
		memberMapper.deleteByExample(me);
		return true;
	}

	public boolean modify(Member m) {
		memberMapper.updateByPrimaryKeySelective(m);
		return true;
	}

	public boolean active(int id) {
		Member m = get(id);
		if(m.getmActive() != null && m.getmActive() > 0) {
			return true;
		}
		m.setId(id);
		m.setmActive(1);
		m.setmActivedate(new Date());
		memberMapper.updateByPrimaryKeySelective(m);
		/*//赋予普通会员角色
		GroupProxy gp = new GroupProxy();
		String comm_group = pp.getValue("comm_group");
		gp.addUserToGroup(m.getmAccount(), comm_group);*/
		//
		TaskEvent te = TaskEvent.ACTIVE_EVENT;
		te.setM(m);
		MoneyTask.addEvent(te);
		return true;
	}

	public Member getAccount(String account) {
		MemberExample me = new MemberExample();
		me.createCriteria().andMAccountEqualTo(account);
		List<Member> l = memberMapper.selectByExample(me);
		if(!l.isEmpty()) {
			return l.get(0);
		}
		return null;
	}

	public boolean restPass(String account, String newPass) {
		MemberExample me = new MemberExample();
		me.createCriteria().andMAccountEqualTo(account);
		Member m = new Member();
		String encodePass = EncodeUtil.md5AndBase64(newPass);
		m.setmPassword(encodePass);
		memberMapper.updateByExampleSelective(m, me);
		//同步更改登录密码
		UserProxy up = new UserProxy();
		User u = up.getUserByAccount(account);
		up.resetPass(account, newPass);
		return true;
	}

	public int cnt(MemberExample me) {
		return memberMapper.countByExample(me);
	}

	public boolean modPass(String account, String oldPass, String newPass) {
		UserProxy up = new UserProxy();
		Map<String, String> map = up.updatePass(account, oldPass, newPass);
		if("true".equals(map.get("success"))) {
			restPass(account, newPass);
			return true;
		}
		return false;
	}

	public void addTotalAndBalance(int id, float money) {
		memberMapper.addTotalAndBalance(id, money);
	}

	public void addDecBalance(int id, float money) {
		memberMapper.addDecBalance(id, money);
	}

}
