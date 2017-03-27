package com.ice.sh1.dao;

import com.ice.sh1.po.CompanyAccount;
import com.ice.sh1.po.CompanyAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyAccountMapper {
    int countByExample(CompanyAccountExample example);

    int deleteByExample(CompanyAccountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CompanyAccount record);

    int insertSelective(CompanyAccount record);

    List<CompanyAccount> selectByExample(CompanyAccountExample example);

    CompanyAccount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CompanyAccount record, @Param("example") CompanyAccountExample example);

    int updateByExample(@Param("record") CompanyAccount record, @Param("example") CompanyAccountExample example);

    int updateByPrimaryKeySelective(CompanyAccount record);

    int updateByPrimaryKey(CompanyAccount record);
}