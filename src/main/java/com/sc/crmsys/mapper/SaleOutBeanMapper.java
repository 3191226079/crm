package com.sc.crmsys.mapper;

import com.sc.crmsys.bean.SaleOutBean;

public interface SaleOutBeanMapper {
    int deleteByPrimaryKey(String saleoutId);

    int insert(SaleOutBean record);

    int insertSelective(SaleOutBean record);

    SaleOutBean selectByPrimaryKey(String saleoutId);

    int updateByPrimaryKeySelective(SaleOutBean record);

    int updateByPrimaryKey(SaleOutBean record);
}