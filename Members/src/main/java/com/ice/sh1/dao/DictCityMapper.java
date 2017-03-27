package com.ice.sh1.dao;

import com.ice.sh1.po.DictCity;
import com.ice.sh1.po.DictCityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DictCityMapper {
    int countByExample(DictCityExample example);

    int deleteByExample(DictCityExample example);

    int deleteByPrimaryKey(Integer nCityid);

    int insert(DictCity record);

    int insertSelective(DictCity record);

    List<DictCity> selectByExample(DictCityExample example);

    DictCity selectByPrimaryKey(Integer nCityid);

    int updateByExampleSelective(@Param("record") DictCity record, @Param("example") DictCityExample example);

    int updateByExample(@Param("record") DictCity record, @Param("example") DictCityExample example);

    int updateByPrimaryKeySelective(DictCity record);

    int updateByPrimaryKey(DictCity record);
}