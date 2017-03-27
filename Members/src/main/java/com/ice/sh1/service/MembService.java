package com.ice.sh1.service;

import ice.tool.Page;

import java.util.List;

import com.ice.sh1.po.Member;
import com.ice.sh1.po.MemberExample;

public interface MembService {

	public int add(Member m);
	
	public Member get(int id);
	
	public Member getAccount(String account);
	
	public List<Member> queryList(MemberExample me);
	
	public Page<Member> queryPage(MemberExample me);
	
	public boolean delete(int id);
	
	public boolean deleteByAccount(String account);
	
	public boolean modify(Member m);
	
	public boolean active(int id);
	
	public boolean restPass(String account, String newPass);
	
	public boolean modPass(String account, String oldPass, String newPass);
	
	public int cnt(MemberExample me);
	
	public void addTotalAndBalance(int id, float money);
	
	public void addDecBalance(int id, float money);
}
