package com.sc.crmsys.mapper;

import com.sc.crmsys.bean.OrderPurchaseBean;

public interface OrderPurchaseBeanMapper {
    int deleteByPrimaryKey(String orderPurchaseId);

    int insert(OrderPurchaseBean record);

    int insertSelective(OrderPurchaseBean record);

    OrderPurchaseBean selectByPrimaryKey(String orderPurchaseId);

    int updateByPrimaryKeySelective(OrderPurchaseBean record);

    int updateByPrimaryKey(OrderPurchaseBean record);
}