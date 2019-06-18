package com.sc.crmsys.mapper;

import com.sc.crmsys.bean.CompanyBean;

public interface CompanyBeanMapper {
    int deleteByPrimaryKey(String companyId);

    int insert(CompanyBean record);

    int insertSelective(CompanyBean record);

    CompanyBean selectByPrimaryKey(String companyId);

    int updateByPrimaryKeySelective(CompanyBean record);

    int updateByPrimaryKey(CompanyBean record);
}