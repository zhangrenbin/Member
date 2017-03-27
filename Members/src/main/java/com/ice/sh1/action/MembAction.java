package com.ice.sh1.action;

import ice.tool.GsonUtil;
import ice.tool.Page;
import ice.tool.validation.StringValidator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ice.sh1.po.DictCity;
import com.ice.sh1.po.DictProvince;
import com.ice.sh1.po.MembTree;
import com.ice.sh1.po.Member;
import com.ice.sh1.po.MemberExample;
import com.ice.sh1.po.MemberExample.Criteria;
import com.ice.sh1.service.DicService;
import com.ice.sh1.service.MembService;
import com.ice.sh1.service.MembTreeService;

@Controller
@RequestMapping("/memb")
public class MembAction extends BaseAction {
	
	@Resource
	private MembService  membService;
	
	@Resource
	private DicService dicService;
	
	@Resource
	private MembTreeService membTreeService;
	
	private static Logger log = Logger.getLogger(MembAction.class);
	
	@RequestMapping("/f_memb_list")
	public ModelAndView list(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("member/membList");
		return mv;
	}
	
	@RequestMapping("/f_memb_list/page")
	public ModelAndView searchPage(HttpServletRequest req) {
		int page = getIntParam(req, "page");
		int rows = getIntParam(req, "rows");
		String payload  = getStringParam(req, "payload");
		ModelAndView mv = new ModelAndView("member/membListSub");
		MemberExample me = new MemberExample();
		if(!StringValidator.isEmpty(payload)) {
			me.or().andMAccountLike("%" + payload + "%");
			me.or().andMCnnameLike("%" + payload + "%");
		}
		if(me.getOredCriteria().isEmpty()) {
			me.or();
		}
		for (Criteria c : me.getOredCriteria()) {
			if(!isGod(req)) {
				Member m = getMyMemb(req);
				c.andMRecommderEqualTo(m.getId());
			}
		}
		me.setSize(rows);
		me.setStart((page - 1) * rows);
		me.setOrderByClause("m_regdate desc");
		Page<Member> p = membService.queryPage(me);
		//字段转义
		mv.addObject("p", p);
		colTranslate(p);
		
		return mv;
	}
	
	private void colTranslate(Page<Member> p) {
		for (Member m : p.getResultList()) {
			m.addExtendPro("activeStr", (m.getmActive() != null &&  m.getmActive() > 0) ? "已激活" : "未激活");
		}
	}
	
	private void colTranslate(Member m) {
		m.addExtendPro("activeStr", (m.getmActive() != null &&  m.getmActive() > 0) ? "已激活" : "未激活");
		DictProvince dp = dicService.getProvince(m.getmProvince());
		if(dp != null) {
			m.addExtendPro("provinceName", dp.getsProvname());
		}
		DictCity dc = dicService.getCity(m.getmCity());
		if(dc != null) {
			m.addExtendPro("cityName", dc.getsCityname());
		}
	}
	
	@RequestMapping("/f_memb_del")
	public void f_memb_del(HttpServletRequest req, HttpServletResponse resp) {
		int id = getIntParam(req, "id");
		membService.delete(id);
		outBack(resp, getFeedJson("true", ""), "json");
		return;
	}
	
	@RequestMapping("/f_memb_eidt/resetPass")
	public void resetPass(HttpServletRequest req, HttpServletResponse resp) {
		String account = getStringParam(req, "account");
		String userPassword = getStringParam(req, "userPassword");
		membService.restPass(account, userPassword);
		outBack(resp, getFeedJson("true", ""), "json");
	}
	
	@RequestMapping("/f_memb_active")
	public void membActive(HttpServletRequest req, HttpServletResponse resp) {
		int id = getIntParam(req, "id");
		membService.active(id);
		outBack(resp, getFeedJson("true", ""), "json");
	}
	
	@RequestMapping("/f_memb_add")
	public ModelAndView preMembAdd(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mv = new ModelAndView("member/membCreate");
		return mv;
	}
	
	@RequestMapping("/f_memb_detail")
	public ModelAndView membDetail(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mv = new ModelAndView("member/membDetail");
		int id = getIntParam(req, "id");
		Member m = membService.get(id);
		if(!isGod(req)) {
			//屏蔽奖金信息
			m.setmTotal(null);
			m.setmBalance(null);
		}
		colTranslate(m);
		mv.addObject("m", m);
		return mv;
	}
	
	@RequestMapping("/f_memb_edit")
	public String membEdit(HttpServletRequest req, Member m, HttpServletResponse resp) {
		String res = validateInput(m, false);
		if(!"true".equals(res)) {
			log.error(res);
		} else {
			membService.modify(m);
		}
		return "redirect:f_memb_detail.do?id=" + m.getId();
	}
	
	@RequestMapping("/f_memb_add/addMemb")
	public void addMemb(HttpServletRequest req, Member m, HttpServletResponse resp) {
		String res = validateInput(m, true);
		if(!"true".equals(res)) {
			outBack(resp, getFeedJson("false", res), "json");
			return ;
		}
		Member mym = getMyMemb(req);
		m.setmRecommder(mym.getId());
		m.setmPassword("123456aA");
		int id = membService.add(m);
		if(id > 0) {
			outBack(resp, getFeedJson("true", "" + id), "json");
			return;
		}
		outBack(resp, getFeedJson("false", "添加失败！"), "json");
	}
	
	@RequestMapping("/f_recomm_tree")
	public ModelAndView f_recomm_tree(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("member/MyRecommTree");
		if(isGod(req)) {
			mv.addObject("god", true);
			String payload  = getStringParam(req, "payload");
			MemberExample me = new MemberExample();
			if(!StringValidator.isEmpty(payload)) {
				me.or().andMAccountLike("%" + payload + "%");
				me.or().andMCnnameLike("%" + payload + "%");
			}
			if(me.getOredCriteria().isEmpty()) {
				me.or();
			}
			for (Criteria c : me.getOredCriteria()) {
				c.andIdNotEqualTo(1);
			}
			//最多查20个人
			me.setSize(20);
			me.setStart(0);
			List<Member> l = membService.queryList(me);
			mv.addObject("l", l);
		}
		return mv;
	}
	
	@RequestMapping("/f_recomm_tree/search")
	public void f_recomm_tree_search(HttpServletRequest req, HttpServletResponse resp) {
		int id = 0;
		if(isGod(req)) {
			id = getIntParam(req, "id");
		} else {
			Member m = getMyMemb(req);
			id = m.getId();
		}
		MembTree mt = membTreeService.getTreeByMembIdNoParent(id);
		outBack(resp, GsonUtil.ObjToString(mt, null), "json");
	}
	
	private String validateInput(Member m, boolean validAccount) {
		if(validAccount) {
			if(accountExist(m.getmAccount())) {
				return "账号已经存在！";
			}
			if(!accountReg(m.getmAccount())) {
				return "账号格式不正确！";
			}
		}
		if(StringValidator.isEmpty(m.getmCnname())) {
			return "会员姓名不能为空！";
		}
		if(!mobileReg(m.getmMobile())) {
			return "手机号格式不正确！";
		}
		if(!mobileReg(m.getmMobile())) {
			return "手机号格式不正确！";
		}
		if(!idnumReg(m.getmIdnum())) {
			return "身份证格式不正确！";
		}
		if(StringValidator.isEmpty(m.getmBAccount()) || !baccountReg(m.getmBAccount())) {
			return "银行卡不正确！";
		}
		if(m.getmProvince() == null) {
			return "请选择省份！";
		}
		if(m.getmCity() == null) {
			return "请选择城市！";
		}
		if(StringValidator.isEmpty(m.getmAddr())) {
			return "请填写详细地址！";
		}
		if(StringValidator.isEmpty(m.getmBank())) {
			return "请填写开户银行！";
		}
		if(StringValidator.isEmpty(m.getmBName())) {
			return "请填写银行账号名称！";
		}
		return "true";
	}
	
	@RequestMapping("/checkAccount")
	public void checkAccount(HttpServletRequest req, HttpServletResponse resp) {
		String mAccount = getStringParam(req, "mAccount");
		if(accountExist(mAccount)) {
			outBack(resp, "账号已经存在！", "text");
			return;
		}
		if(!accountReg(mAccount)) {
			outBack(resp, "账号格式不合法！", "text");
			return;
		}
		outBack(resp, "true", "text");
	}
	
	private boolean accountExist(String account) {
		Member m = membService.getAccount(account);
		return m == null ? false : true;
	}
	
	private boolean accountReg(String account) {
		Matcher m = Pattern.compile("^[a-zA-z][a-zA-Z0-9_]{3,15}$").matcher(account);
		return m.matches();
	}
	
	private boolean mobileReg(String mobile) {
		Matcher m = Pattern.compile("^1(3[0-9]|4[57]|5[0-35-9]|7[0135678]|8[0-9])\\d{8}$").matcher(mobile);
		return m.matches();
	}
	
	private boolean idnumReg(String idnum) {
		Matcher m = Pattern.compile("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$").matcher(idnum);
		return m.matches();
	}
	
	private boolean baccountReg(String idnum) {
		Matcher m = Pattern.compile("\\d{16,19}").matcher(idnum);
		return m.matches();
	}
	
	public static void main(String[] args) {
		System.out.println(new MembAction().idnumReg("370126198512255939"));
	}
}
