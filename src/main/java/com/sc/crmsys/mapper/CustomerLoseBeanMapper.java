package com.sc.crmsys.mapper;

import com.sc.crmsys.bean.CustomerLoseBean;

public interface CustomerLoseBeanMapper {
    int deleteByPrimaryKey(String customerLoseId);

    int insert(CustomerLoseBean record);

    int insertSelective(CustomerLoseBean record);

    CustomerLoseBean selectByPrimaryKey(String customerLoseId);

    int updateByPrimaryKeySelective(CustomerLoseBean record);

    int updateByPrimaryKey(CustomerLoseBean record);
}