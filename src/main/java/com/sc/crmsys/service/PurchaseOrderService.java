package com.sc.crmsys.service;

import java.util.Date;
import java.util.List;

import com.sc.crmsys.bean.DetailPurchaseBean;
import com.sc.crmsys.bean.OrderPurchaseBean;
import com.sc.crmsys.bean.SupplierBean;

public interface PurchaseOrderService {

	List<OrderPurchaseBean> getPurchaseOrder();
	
	void delPurchaseOrder(String orderPurchaseId,Date orderPurchaseUpdateTime);
	
	void updatePurchaseOrder(OrderPurchaseBean orderPurchaseBean);
	
	OrderPurchaseBean find(String orderPurchaseId);
	
	void addPurchaseOrder(OrderPurchaseBean orderPurchaseBean);

	
	
}
