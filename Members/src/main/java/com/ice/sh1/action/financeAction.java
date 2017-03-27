package com.ice.sh1.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ice.sh1.po.BdCenter;
import com.ice.sh1.po.BdCenterExample;
import com.ice.sh1.po.BonusRecord;
import com.ice.sh1.po.BonusRecordExample;
import com.ice.sh1.po.Member;
import com.ice.sh1.po.MemberExample;
import com.ice.sh1.po.Remits;
import com.ice.sh1.po.RemitsExample;
import com.ice.sh1.po.WithDraw;
import com.ice.sh1.po.WithDrawExample;
import com.ice.sh1.service.BdCenterService;
import com.ice.sh1.service.BonusRecordService;
import com.ice.sh1.service.MembService;
import com.ice.sh1.service.RemitService;
import com.ice.sh1.service.WithDrawService;

import ice.tool.Page;
import ice.tool.validation.StringValidator;

@Controller
@RequestMapping("/finance")
public class financeAction extends BaseAction {
	
	@Resource
	private RemitService remitService;
	
	@Resource
	private MembService membService;
	
	@Resource
	private BonusRecordService bonusRecordService;
	
	@Resource
	private WithDrawService withDrawService;
	
	@Resource
	private BdCenterService bdCenterService;

	@RequestMapping("/f_remit_notice")
	public String remitPage(HttpServletRequest req) {
		//查询报单中心
		BdCenterExample be = new BdCenterExample();
		be.createCriteria().andBStateEqualTo(1);
		List<BdCenter> l = bdCenterService.queryList(be);
		req.setAttribute("bdl", l);
		return "finance/remitNotice";
	}
	
	@RequestMapping("/f_remit_notice/sub")
	public void remitSub(HttpServletRequest req, Remits rm, HttpServletResponse resp) {
		Member m = getMyMemb(req);
		rm.setrFromUser(m.getId());
		if(StringValidator.isEmpty(rm.getrBAccount()) || rm.getrBAccount().length() < 16 ||
				19 < rm.getrBAccount().length()) {
			outBack(resp, getFeedJson("false", "银行账户不合法!"), "json");
			return;
		}
		if(StringValidator.isEmpty(rm.getrBName())) {
			outBack(resp, getFeedJson("false", "账户姓名能为空!"), "json");
			return;
		}
		if(null == rm.getrMoney() || rm.getrMoney() < 0 || rm.getrMoney() > 99999999) {
			outBack(resp, getFeedJson("false", "汇款金额不合法!"), "json");
			return;
		}
		if(StringValidator.isEmpty(rm.getrRemark())) {
			outBack(resp, getFeedJson("false", "汇款备注为空!"), "json");
			return;
		}
		remitService.subRemit(rm);
		outBack(resp, getFeedJson("true", ""), "json");
	}
	
	@RequestMapping("/f_remit_notice/list")
	public ModelAndView remitList(HttpServletRequest req, HttpServletResponse resp) {
		Member m = getMyMemb(req);
		int size = getPageSize(req);
		int start = (getPageIndex(req) - 1) * size;
		Page<Remits> p = remitService.getRemitsPageByMemb(start, size, m.getId());
		tranlate(p);
		ModelAndView mv = new ModelAndView("finance/myRemitListSub");
		mv.addObject("p", p);
		return mv;
	}
	
	private void tranlate(Page<Remits> p) {
		BdCenterExample be = new BdCenterExample();
		be.createCriteria().andBStateEqualTo(1);
		List<BdCenter> l = bdCenterService.queryList(be);
		for(Remits r : p.getResultList()) {
			for (BdCenter bd : l) {
				if(bd.getmId().equals(r.getrBdmemb())) {
					r.addExtendPro("bdName", bd.getmCnname());
					r.addExtendPro("bdAccount", bd.getmAccount());
					break;
				}
			}
			if(r.getrState() == null || r.getrState() == 0) {
				r.addExtendPro("stateStr", "未确认");
			} else if(r.getrState() > 0) {
				r.addExtendPro("stateStr", "已确认");
			} else {
				r.addExtendPro("stateStr", "被驳回");
			}
		}
	}
	
	@RequestMapping("/f_remit_config")
	public String remitConfig(HttpServletRequest req) {
		return "finance/remitConfig";
	}
	
	@RequestMapping("/f_remit_config/page")
	public ModelAndView remitConfigPage(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("finance/remitConfigSub");
		String payload = getStringParam(req, "payload");
		MemberExample me = new MemberExample();
		if(!StringValidator.isEmpty(payload)) {
			me.or().andMAccountLike("%" + payload + "%");
			me.or().andMCnnameLike("%" + payload + "%");
		}
		List<Member> l = membService.queryList(me);
		List<Integer> midList = new ArrayList<Integer>();
		for (Member m : l) {
			midList.add(m.getId());
		}
		midList.add(-1);
		RemitsExample re = new RemitsExample();
		re.createCriteria().andRFromUserIn(midList);
		int page = getIntParam(req, "page");
		int rows = getIntParam(req, "rows");
		re.setSize(rows);
		re.setStart((page - 1) * rows);
		Page<Remits> p = remitService.queryRemitsPage(re);
		tranlate(p);
		mv.addObject("p", p);
		return mv;
	}
	
	@RequestMapping("/f_remit_config/config")
	public void remitConfig(HttpServletRequest req, HttpServletResponse resp) {
		int id = getIntParam(req, "id");
		String acc = getAccount(req);
		remitService.confirmRemit(id, acc);
		outBack(resp, getFeedJson("true", ""), "json");
	}
	
	@RequestMapping("/f_remit_config/reject")
	public void remitReject(HttpServletRequest req, HttpServletResponse resp) {
		int id = getIntParam(req, "id");
		String acc = getAccount(req);
		remitService.rejectRemit(id, acc);
		outBack(resp, getFeedJson("true", ""), "json");
	}
	
	@RequestMapping("/f_bonus_record")
	public ModelAndView f_bonus_record(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("finance/myBonusRecord");
		if(isGod(req)) {
			mv.addObject("god", true);
		}
		return mv;
	}
	
	@RequestMapping("/f_bonus_record/page")
	public ModelAndView f_bonus_record_page(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("finance/myBonusRecordSub");
		if(isGod(req)) {
			mv.addObject("god", true);
		}
		BonusRecordExample re = new BonusRecordExample();
		if(isGod(req)) {
			MemberExample me = new MemberExample();
			String payload = getStringParam(req, "payload");
			if(!StringValidator.isEmpty(payload)) {
				me.or().andMAccountLike("%" + payload + "%");
				me.or().andMCnnameLike("%" + payload + "%");
			}
			List<Member> l = membService.queryList(me);
			List<Integer> midList = new ArrayList<Integer>();
			for (Member m : l) {
				midList.add(m.getId());
			}
			midList.add(-1);
			re.createCriteria().andRMemberIn(midList);
		} else {
			Member m = getMyMemb(req);
			re.createCriteria().andRMemberEqualTo(m.getId());
		}
		int page = getIntParam(req, "page");
		int rows = getIntParam(req, "rows");
		re.setSize(rows);
		re.setStart((page - 1) * rows);
		re.setOrderByClause("r_point asc,r_time desc");
		Page<BonusRecord> p = bonusRecordService.queryPage(re);
		mv.addObject("p", p);
		return mv;
	}
	
	@RequestMapping("/f_bonus_record/baodan")
	public void baodan(HttpServletRequest req, HttpServletResponse resp) {
		int id = getIntParam(req, "id");
		BonusRecord br = bonusRecordService.get(id);
		Member m = getMyMemb(req);
		if(m.getId() != br.getrMember() && !isGod(req)) {
			//不是提交自己的报单
			outBack(resp, getFeedJson("false", "您无权提交此报单"), "json");
			return;
		}
		boolean b = bonusRecordService.baodan(id);
		if(b) {
			outBack(resp, getFeedJson("true", ""), "json");
			return;
		}
		outBack(resp, getFeedJson("false", "提交失败!"), "json");
	}
	
	@RequestMapping("/f_bonus_record/chuli")
	public void chuli(HttpServletRequest req, HttpServletResponse resp) {
		if(!isGod(req)) {
			outBack(resp, getFeedJson("false", "您无权处理"), "json");
			return;
		}
		int id = getIntParam(req, "id");
		boolean b = bonusRecordService.chuli(id);
		if(b) {
			outBack(resp, getFeedJson("true", ""), "json");
			return;
		}
		outBack(resp, getFeedJson("false", "处理失败!"), "json");
	}
	
	@RequestMapping("/f_withdraw_apply/list")
	public ModelAndView f_withdraw_apply_list(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("finance/withdrawApplySub");
		//查询我的信息
		Member m = getMyMemb(req);
		int page = getIntParam(req, "page");
		int rows = getIntParam(req, "rows");
		Page<WithDraw> p = withDrawService.getByMemb(m.getId(), page, rows);
		mv.addObject("p", p);
		return mv;
	}
	
	@RequestMapping("/f_withdraw_apply")
	public ModelAndView f_withdraw_apply(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("finance/withdrawApply");
		//查询我的信息
		Member m = getMyMemb(req);
		m = membService.get(m.getId());
		mv.addObject("m", m);
		float lock = withDrawService.getMyLockMoney(m.getId());
		mv.addObject("lock", lock);
		return mv;
	}
	
	@RequestMapping("/f_withdraw_apply/sub")
	public void f_withdraw_apply_sub(HttpServletRequest req, WithDraw wd, HttpServletResponse resp) {
		String succ = "true";
		Member m = getMyMemb(req);
		m = membService.get(m.getId());
		if(wd == null) {
			succ = "保存失败！";
		} else if(StringValidator.isEmpty(wd.getTxBAccount())) {
			succ = "银行账号不合法！";
		} else if(StringValidator.isEmpty(wd.getTxBank())) {
			succ = "开户银行不合法！";
		} else if(StringValidator.isEmpty(wd.getTxBName())) {
			succ = "账号姓名不合法！";
		} else if(wd.getTxMoney() <=0 || wd.getTxMoney() % 100 != 0) {
			succ = "提现金额不合法！";
		} else if(wd.getTxMoney() > m.getmBalance()) {
			succ = "余额不足！";
		}
		
		if(!"true".equals(succ)) {
			outBack(resp, getFeedJson("false", succ), "json");
			return;
		}
		wd.setMembId(m.getId());
		wd.setTxDate(new Date());
		wd.setState(0);
		withDrawService.add(wd);
		float lock = withDrawService.getMyLockMoney(m.getId());
		float valid = m.getmBalance() - lock;
		outBack(resp, getFeedJson("true", "{\"lock\":" + lock + 
				",\"valid\":" + valid + "}"), "json");
	}
	
	@RequestMapping("/f_withDraw_approve")
	public ModelAndView f_withDraw_approve(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("finance/withdrawApprove");
		return mv;
	}
	
	@RequestMapping("/f_withDraw_approve/page")
	public ModelAndView f_withDraw_approve_page(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("finance/withdrawApproveSub");
		MemberExample me = new MemberExample();
		WithDrawExample we = new WithDrawExample();
		String payload = getStringParam(req, "payload");
		if(!StringValidator.isEmpty(payload)) {
			me.or().andMAccountLike("%" + payload + "%");
			me.or().andMCnnameLike("%" + payload + "%");
			List<Member> l = membService.queryList(me);
			List<Integer> midList = new ArrayList<Integer>();
			for (Member m : l) {
				midList.add(m.getId());
			}
			midList.add(-1);
			we.createCriteria().andMembIdIn(midList);
		}
		int page = getIntParam(req, "page");
		int rows = getIntParam(req, "rows");
		we.setSize(rows);
		we.setStart((page - 1) * rows);
		we.setOrderByClause("state asc, tx_date desc");
		Page<WithDraw> p = withDrawService.queryPage(we);
		mv.addObject("p", p);
		return mv;
	}
	
	@RequestMapping("/f_withDraw_approve/ok")
	public void f_withDraw_approve_ok(HttpServletRequest req, HttpServletResponse resp) {
		int id = getIntParam(req, "id");
		boolean b = withDrawService.ok(id, getAccount(req));
		if(b) {
			outBack(resp, getFeedJson("true", ""), "json");
		} else {
			outBack(resp, getFeedJson("false", "处理失败"), "json");
		}
	}
	
	@RequestMapping("/f_withDraw_approve/reject")
	public void f_withDraw_approve_reject(HttpServletRequest req, HttpServletResponse resp) {
		int id = getIntParam(req, "id");
		String msg = getStringParam(req, "msg");
		boolean b = withDrawService.reject(id, msg, getAccount(req));
		if(b) {
			outBack(resp, getFeedJson("true", ""), "json");
		} else {
			outBack(resp, getFeedJson("false", "处理失败"), "json");
		}
	}
}
