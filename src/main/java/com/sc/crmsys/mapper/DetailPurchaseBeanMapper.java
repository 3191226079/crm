package com.sc.crmsys.mapper;

import com.sc.crmsys.bean.DetailPurchaseBean;

public interface DetailPurchaseBeanMapper {
    int deleteByPrimaryKey(String detailPurchaseId);

    int insert(DetailPurchaseBean record);

    int insertSelective(DetailPurchaseBean record);

    DetailPurchaseBean selectByPrimaryKey(String detailPurchaseId);

    int updateByPrimaryKeySelective(DetailPurchaseBean record);

    int updateByPrimaryKey(DetailPurchaseBean record);
    
    void update(DetailPurchaseBean record);
}