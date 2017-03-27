package com.ice.sh1.dao;

import com.ice.sh1.po.DictProvince;
import com.ice.sh1.po.DictProvinceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DictProvinceMapper {
    int countByExample(DictProvinceExample example);

    int deleteByExample(DictProvinceExample example);

    int deleteByPrimaryKey(Integer nProvid);

    int insert(DictProvince record);

    int insertSelective(DictProvince record);

    List<DictProvince> selectByExample(DictProvinceExample example);

    DictProvince selectByPrimaryKey(Integer nProvid);

    int updateByExampleSelective(@Param("record") DictProvince record, @Param("example") DictProvinceExample example);

    int updateByExample(@Param("record") DictProvince record, @Param("example") DictProvinceExample example);

    int updateByPrimaryKeySelective(DictProvince record);

    int updateByPrimaryKey(DictProvince record);
}