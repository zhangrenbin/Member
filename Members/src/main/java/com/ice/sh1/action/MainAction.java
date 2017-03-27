package com.ice.sh1.action;

import ice.tool.DateUtil;
import ice.tool.GsonUtil;
import ice.tool.validation.StringValidator;

import java.util.ArrayList;
import java.util.Date;
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
import com.ice.sh1.po.Member;
import com.ice.sh1.po.MemberExample;
import com.ice.sh1.po.Remits;
import com.ice.sh1.po.RemitsExample;
import com.ice.sh1.service.DicService;
import com.ice.sh1.service.MembService;
import com.ice.sh1.service.RemitService;
import com.inspur.guarder.pojo.User;

@Controller
@RequestMapping("/main")
public class MainAction extends BaseAction {
	
	@Resource
	private MembService membService;
	
	@Resource
	private DicService dicService;
	
	@Resource
	private RemitService remitService;
	
	private static Logger log = Logger.getLogger(MainAction.class);

	@RequestMapping("/f_user_main")
	public ModelAndView userMain(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("user_main");
		Member m = getMyMemb(req);
		if(!isGod(req)) {
			//查询推荐的会员数
			MemberExample me = new MemberExample();
			me.createCriteria().andMRecommderEqualTo(m.getId());
			int myRecommed = membService.cnt(me);
			m.addExtendPro("myRecommed", myRecommed);
		} else {
			mv.setViewName("admin_mian");
			MemberExample me = new MemberExample();
			//查询总会员数
			int total = membService.cnt(me);
			m.addExtendPro("total", total);
			//查询激活会员数
			me.createCriteria().andMActiveGreaterThan(0);
			int activeNum = membService.cnt(me);
			m.addExtendPro("activeNum", activeNum);
			//今日新注册会员数
			me.clear();
			Date d = new Date();
			d = DateUtil.get(DateUtil.getYear(d), DateUtil.getMonth(d), DateUtil.getDay(d));
			me.createCriteria().andMRegdateGreaterThan(d);
			int todayNum = membService.cnt(me);
			m.addExtendPro("todayNum", todayNum);
		}
		User u = getMyUser(req);
		m.addExtendPro("lastLoginTime", u.getLastlogintime());
		mv.addObject("m", m);
		return mv;
	}
	
	@RequestMapping("/f_user_main/getRecentRecomm")
	public void getRecentRecomm(HttpServletRequest req, HttpServletResponse resp) {
		Member m = getMyMemb(req);
		//查询推荐的会员数
		MemberExample me = new MemberExample();
		me.createCriteria().andMRecommderEqualTo(m.getId());
		me.setOrderByClause("m_regdate desc");
		me.setSize(5);
		me.setStart(0);
		List<Member> l = membService.queryList(me);
		outBack(resp, GsonUtil.ObjToString(l, null), "json");
	}
	
	@RequestMapping("/modPass")
	public void modPass(HttpServletRequest req, HttpServletResponse resp) {
		String account = getAccount(req);
		String oldPass = getStringParam(req, "oldPassword");
		String newPass = getStringParam(req, "userPassword");
		if(StringValidator.isEmpty(newPass) || newPass.length() > 18 || newPass.length() < 6) {
			outBack(resp, getFeedJson("false", "修改失败，新密码格式不正确！"), "json");
		}
		boolean b = membService.modPass(account, oldPass, newPass);
		if(b) {
			outBack(resp, getFeedJson("true", ""), "json");
			return;
		}
		outBack(resp, getFeedJson("false", "修改失败，原密码不正确！"), "json");
	}
	
	@RequestMapping("/myInfo")
	public ModelAndView myInfo(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("myInfo");
		Member m = getMyMemb(req);
		m = membService.get(m.getId());
		colTranslate(m);
		mv.addObject("m", m);
		return mv;
	}
	
	@RequestMapping("/editMyInfo")
	public String membEdit(HttpServletRequest req, Member m, HttpServletResponse resp) {
		/*String res = validateInput(m, false);
		if(!"true".equals(res)) {
			log.error(res);
		} else {
			membService.modify(m);
		}*/
		return "redirect:myInfo.do";
	}
	
	@RequestMapping("/f_user_main/getNewMembs")
	public void getNewMembs(HttpServletRequest req,HttpServletResponse resp) {
		MemberExample me = new MemberExample();
		me.setOrderByClause("m_regdate desc");
		me.setSize(5);
		me.setStart(0);
		List<Member> l = membService.queryList(me);
		outBack(resp, GsonUtil.ObjToString(l, null), "json");
	}
	
	@RequestMapping("/f_user_main/getNewRemit")
	public void getNewRemit(HttpServletRequest req,HttpServletResponse resp) {
		List<Remits> l = null;
		if(!isGod(req)) {
			l = new ArrayList<Remits>();
		} else {
			RemitsExample me = new RemitsExample();
			me.setOrderByClause("r_sub_date desc");
			me.setSize(5);
			me.setStart(0);
			l = remitService.queryRemits(me);
		}
		outBack(resp, GsonUtil.ObjToString(l, null), "json");
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
		if(!StringValidator.isEmpty(m.getmBAccount()) && !baccountReg(m.getmBAccount())) {
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
		return "true";
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
}
