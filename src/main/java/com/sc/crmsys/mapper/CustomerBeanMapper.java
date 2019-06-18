package com.sc.crmsys.mapper;

import com.sc.crmsys.bean.CustomerBean;

public interface CustomerBeanMapper {
    int deleteByPrimaryKey(String customerId);

    int insert(CustomerBean record);

    int insertSelective(CustomerBean record);

    CustomerBean selectByPrimaryKey(String customerId);

    int updateByPrimaryKeySelective(CustomerBean record);

    int updateByPrimaryKey(CustomerBean record);
}