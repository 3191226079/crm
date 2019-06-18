package com.sc.crmsys.mapper;

import com.sc.crmsys.bean.SaleInfoBean;

public interface SaleInfoBeanMapper {
    int deleteByPrimaryKey(String saleinfoId);

    int insert(SaleInfoBean record);

    int insertSelective(SaleInfoBean record);

    SaleInfoBean selectByPrimaryKey(String saleinfoId);

    int updateByPrimaryKeySelective(SaleInfoBean record);

    int updateByPrimaryKey(SaleInfoBean record);
}