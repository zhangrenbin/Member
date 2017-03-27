package com.ice.sh1.dao;

import com.ice.sh1.po.WithDraw;
import com.ice.sh1.po.WithDrawExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WithDrawMapper {
    int countByExample(WithDrawExample example);

    int deleteByExample(WithDrawExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WithDraw record);

    int insertSelective(WithDraw record);

    List<WithDraw> selectByExample(WithDrawExample example);

    WithDraw selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WithDraw record, @Param("example") WithDrawExample example);

    int updateByExample(@Param("record") WithDraw record, @Param("example") WithDrawExample example);

    int updateByPrimaryKeySelective(WithDraw record);

    int updateByPrimaryKey(WithDraw record);
}