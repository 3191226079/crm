package com.sc.crmsys.mapper;

import java.util.Date;
import java.util.List;

import com.sc.crmsys.bean.OrderPurchaseBean;

public interface OrderPurchaseBeanMapper {
    int deleteByPrimaryKey(String orderPurchaseId);

    int insert(OrderPurchaseBean record);

    int insertSelective(OrderPurchaseBean record);

    OrderPurchaseBean selectByPrimaryKey(String orderPurchaseId);

    int updateByPrimaryKeySelective(OrderPurchaseBean record);

    int updateByPrimaryKey(OrderPurchaseBean record);
    
    void update(OrderPurchaseBean record);
    
    List<OrderPurchaseBean> getPurchaseOrder();
    
    OrderPurchaseBean find(String orderPurchaseId);
    
    void updateState(String orderPurchaseId,Date orderPurchaseUpdateTime);
}