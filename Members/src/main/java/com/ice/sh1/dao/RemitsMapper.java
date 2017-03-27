package com.ice.sh1.dao;

import com.ice.sh1.po.Remits;
import com.ice.sh1.po.RemitsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RemitsMapper {
    int countByExample(RemitsExample example);

    int deleteByExample(RemitsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Remits record);

    int insertSelective(Remits record);

    List<Remits> selectByExample(RemitsExample example);

    Remits selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Remits record, @Param("example") RemitsExample example);

    int updateByExample(@Param("record") Remits record, @Param("example") RemitsExample example);

    int updateByPrimaryKeySelective(Remits record);

    int updateByPrimaryKey(Remits record);
}