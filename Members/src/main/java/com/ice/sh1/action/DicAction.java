package com.ice.sh1.action;

import ice.tool.GsonUtil;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ice.sh1.po.DictCity;
import com.ice.sh1.po.DictProvince;
import com.ice.sh1.service.DicService;

@Controller
@RequestMapping("/dic")
public class DicAction extends BaseAction {
	
	@Resource
	private DicService dicService;

	@RequestMapping("/getProvince")
	public void getProvince(HttpServletRequest req, HttpServletResponse resp) {
		List<DictProvince> l = dicService.getProvinces();
		outBack(resp, GsonUtil.ObjToString(l, null), "json");
	}
	
	@RequestMapping("/getCity")
	public void getCity(HttpServletRequest req, HttpServletResponse resp) {
		int province = getIntParam(req, "province");
		List<DictCity> l = dicService.getCitys(province);
		outBack(resp, GsonUtil.ObjToString(l, null), "json");
	}
}
