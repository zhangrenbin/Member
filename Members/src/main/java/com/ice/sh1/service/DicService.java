package com.ice.sh1.service;

import java.util.List;

import com.ice.sh1.po.DictCity;
import com.ice.sh1.po.DictProvince;

public interface DicService {

	public List<DictProvince> getProvinces();
	
	public List<DictCity> getCitys(int province);
	
	public DictProvince getProvince(int id);
	
	public DictCity getCity(int id);
}
