package com.ice.sh1.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ice.sh1.dao.DictCityMapper;
import com.ice.sh1.dao.DictProvinceMapper;
import com.ice.sh1.po.DictCity;
import com.ice.sh1.po.DictCityExample;
import com.ice.sh1.po.DictProvince;
import com.ice.sh1.po.DictProvinceExample;
import com.ice.sh1.service.DicService;

@Service("dicService")
public class DicServiceImpl implements DicService {
	
	@Resource
	private DictProvinceMapper dictProvinceMapper;
	
	@Resource
	private DictCityMapper dictCityMapper;

	public List<DictProvince> getProvinces() {
		return dictProvinceMapper.selectByExample(new DictProvinceExample());
	}

	public List<DictCity> getCitys(int province) {
		DictCityExample ce = new DictCityExample();
		ce.createCriteria().andNProvidEqualTo(province);
		return dictCityMapper.selectByExample(ce);
	}

	public DictProvince getProvince(int id) {
		return dictProvinceMapper.selectByPrimaryKey(id);
	}

	public DictCity getCity(int id) {
		return dictCityMapper.selectByPrimaryKey(id);
	}

}
