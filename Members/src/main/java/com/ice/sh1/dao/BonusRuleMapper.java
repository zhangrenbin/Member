package com.ice.sh1.dao;

import com.ice.sh1.po.BonusRule;
import com.ice.sh1.po.BonusRuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BonusRuleMapper {
    int countByExample(BonusRuleExample example);

    int deleteByExample(BonusRuleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BonusRule record);

    int insertSelective(BonusRule record);

    List<BonusRule> selectByExample(BonusRuleExample example);

    BonusRule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BonusRule record, @Param("example") BonusRuleExample example);

    int updateByExample(@Param("record") BonusRule record, @Param("example") BonusRuleExample example);

    int updateByPrimaryKeySelective(BonusRule record);

    int updateByPrimaryKey(BonusRule record);
}