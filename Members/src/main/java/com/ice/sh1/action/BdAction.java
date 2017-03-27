package com.ice.sh1.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ice.sh1.po.BdCenter;
import com.ice.sh1.po.BdCenterExample;
import com.ice.sh1.po.Member;
import com.ice.sh1.po.MemberExample;
import com.ice.sh1.service.BdCenterService;
import com.ice.sh1.service.MembService;

import ice.tool.Page;
import ice.tool.validation.StringValidator;

@Controller
@RequestMapping("/bd")
public class BdAction extends BaseAction {
	
	@Resource
	private BdCenterService BdCenterService;
	
	@Resource
	private MembService membService;

	@RequestMapping("/f_bd_apply")
	public ModelAndView bd_apply(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("bd/bdApply");
		Member m = getMyMemb(req);
		BdCenter bd = BdCenterService.getByMemb(m.getId());
		mv.addObject("bd", bd);
		return mv;
	}
	
	@RequestMapping("/f_bd_apply/sub")
	public ModelAndView bd_apply_sub(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mv = new ModelAndView("bd/bdApply");
		String bRemark = getStringParam(req, "bRemark");
		Member m = getMyMemb(req);
		BdCenter bd = new BdCenter();
		bd.setmId(m.getId());
		bd.setbRemark(bRemark);
		int id = BdCenterService.add(bd);
		mv.addObject("bd", bd);
		if(id < 1) {
			mv.addObject("error", "提交失败!");
			return mv;
		}
		return mv;
	}
	
	@RequestMapping("/f_bd_approve")
	public ModelAndView bd_approve(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("bd/bdApproveList");
		return mv;
	}
	
	@RequestMapping("/f_bd_approve/page")
	public ModelAndView bd_approve_page(HttpServletRequest req) {
		int page = getIntParam(req, "page");
		int rows = getIntParam(req, "rows");
		String payload  = getStringParam(req, "payload");
		ModelAndView mv = new ModelAndView("bd/bdApproveListSub");
		BdCenterExample be = new BdCenterExample();
		be.setSize(rows);
		be.setStart((page - 1) * rows);
		be.setOrderByClause("b_date desc");
		
		if(!StringValidator.isEmpty(payload)) {
			MemberExample me = new MemberExample();
			me.or().andMAccountLike("%" + payload + "%");
			me.or().andMCnnameLike("%" + payload + "%");
			List<Member> ml = membService.queryList(me);
			List<Integer> idl = new ArrayList<Integer>();
			for (Member m : ml) {
				idl.add(m.getId());
			}
			idl.add(-1);
			be.createCriteria().andMIdIn(idl);
		}
		Page<BdCenter> p = BdCenterService.queryPage(be);
		mv.addObject("p", p);
		return  mv;
	}
	
	@RequestMapping("/f_bd_approve/ok")
	public void bd_approve_ok(HttpServletRequest req, HttpServletResponse resp) {
		int id = getIntParam(req, "id");
		boolean b = BdCenterService.ok(id);
		if(b) {
			outBack(resp, getFeedJson("true", ""), "json");
			return;
		}
		outBack(resp, getFeedJson("false", "审批失败"), "json");
	}
	
	@RequestMapping("/f_bd_approve/reject")
	public void bd_approve_reject(HttpServletRequest req, HttpServletResponse resp) {
		int id = getIntParam(req, "id");
		boolean b = BdCenterService.reject(id);
		if(b) {
			outBack(resp, getFeedJson("true", ""), "json");
			return;
		}
		outBack(resp, getFeedJson("false", "审批失败"), "json");
	}
}
