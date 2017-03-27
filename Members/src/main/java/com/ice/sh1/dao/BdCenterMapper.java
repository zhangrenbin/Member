package com.ice.sh1.dao;

import com.ice.sh1.po.BdCenter;
import com.ice.sh1.po.BdCenterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BdCenterMapper {
    int countByExample(BdCenterExample example);

    int deleteByExample(BdCenterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BdCenter record);

    int insertSelective(BdCenter record);

    List<BdCenter> selectByExample(BdCenterExample example);

    BdCenter selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BdCenter record, @Param("example") BdCenterExample example);

    int updateByExample(@Param("record") BdCenter record, @Param("example") BdCenterExample example);

    int updateByPrimaryKeySelective(BdCenter record);

    int updateByPrimaryKey(BdCenter record);
}