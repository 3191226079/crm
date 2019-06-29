package com.sc.crmsys.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sc.crmsys.bean.DetailPurchaseBean;
import com.sc.crmsys.bean.OrderPurchaseBean;
import com.sc.crmsys.bean.SupplierBean;
import com.sc.crmsys.mapper.OrderPurchaseBeanMapper;

@Service("purchaseOrderService")
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
	
	@Resource
	private OrderPurchaseBeanMapper orderPurchaseBeanMapper;

	@Override
	public List<OrderPurchaseBean> getPurchaseOrder() {
		List<OrderPurchaseBean> list = orderPurchaseBeanMapper.getPurchaseOrder();
		return list;
	}

	@Override
	public void delPurchaseOrder(String orderPurchaseId, Date orderPurchaseUpdateTime) {
		orderPurchaseBeanMapper.updateState(orderPurchaseId, orderPurchaseUpdateTime);
		
	}


	@Override
	public void addPurchaseOrder(OrderPurchaseBean orderPurchaseBean) {
		
		orderPurchaseBeanMapper.insert(orderPurchaseBean);
		
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePurchaseOrder(OrderPurchaseBean orderPurchaseBean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrderPurchaseBean find(String orderPurchaseId) {
		OrderPurchaseBean orderPurchaseBean = orderPurchaseBeanMapper.find(orderPurchaseId);
		return orderPurchaseBean;
	}

}
