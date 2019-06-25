package com.sc.crmsys.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sc.crmsys.bean.DetailPurchaseBean;
import com.sc.crmsys.bean.OrderPurchaseBean;
import com.sc.crmsys.bean.PurchaseBean;
import com.sc.crmsys.bean.StockBean;


public interface PurchaseService {
	
	List<PurchaseBean> getPurchase(String companyId);
	
	void addPurchase(PurchaseBean purchaseBean,DetailPurchaseBean detailPurchaseBean,OrderPurchaseBean orderPurchaseBean);
	
	List<PurchaseBean> findPurchase(String purchaseId);
	
	void updatePurchase(PurchaseBean purchaseBean,DetailPurchaseBean detailPurchaseBean,OrderPurchaseBean orderPurchaseBean);
	
	void updatePurchaseState(String purchaseId,Date purchaseUpdateTime);
	
}
