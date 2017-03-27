package com.ice.sh1.dao;

import com.ice.sh1.po.BonusRecord;
import com.ice.sh1.po.BonusRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BonusRecordMapper {
    int countByExample(BonusRecordExample example);

    int deleteByExample(BonusRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BonusRecord record);

    int insertSelective(BonusRecord record);

    List<BonusRecord> selectByExample(BonusRecordExample example);

    BonusRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BonusRecord record, @Param("example") BonusRecordExample example);

    int updateByExample(@Param("record") BonusRecord record, @Param("example") BonusRecordExample example);

    int updateByPrimaryKeySelective(BonusRecord record);

    int updateByPrimaryKey(BonusRecord record);
}