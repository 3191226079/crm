package com.sc.crmsys.mapper;

import com.sc.crmsys.bean.PurchaseBean;

public interface PurchaseBeanMapper {
    int deleteByPrimaryKey(String purchaseId);

    int insert(PurchaseBean record);

    int insertSelective(PurchaseBean record);

    PurchaseBean selectByPrimaryKey(String purchaseId);

    int updateByPrimaryKeySelective(PurchaseBean record);

    int updateByPrimaryKey(PurchaseBean record);
}