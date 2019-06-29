package com.sc.crmsys.mapper;


import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.format.annotation.DateTimeFormat;

import com.sc.crmsys.bean.PurchaseBean;


public interface PurchaseBeanMapper {
    int deleteByPrimaryKey(String purchaseId);

    int insert(PurchaseBean record);

    int insertSelective(PurchaseBean record);

    PurchaseBean selectByPrimaryKey(String purchaseId);

    int updateByPrimaryKeySelective(PurchaseBean record);

    int updateByPrimaryKey(PurchaseBean record);
    
    PurchaseBean getByPrimaryKey(String purchaseId,String productId);
    
    List<PurchaseBean> getByPrimaryKey();
    
    List<PurchaseBean> findByPrimaryKey(String purchaseId);
    
    void updateState(@Param("purchaseId")String purchaseId,@Param("purchaseUpdateTime")Date purchaseUpdateTime);
    
    void update(PurchaseBean purchaseBean);
    
    
    
    
    
}