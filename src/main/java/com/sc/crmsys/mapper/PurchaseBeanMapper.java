package com.sc.crmsys.mapper;

import java.util.List;

import com.sc.crmsys.bean.PurchaseBean;


public interface PurchaseBeanMapper {
    int deleteByPrimaryKey(String purchaseId);

    int insert(PurchaseBean record);

    int insertSelective(PurchaseBean record);

    PurchaseBean selectByPrimaryKey(String purchaseId);

    int updateByPrimaryKeySelective(PurchaseBean record);

    int updateByPrimaryKey(PurchaseBean record);
    
    PurchaseBean getByPrimaryKey(String purchaseId,String productId);
    
    List<PurchaseBean> getByPrimaryKey(String companyId);
    
    
}