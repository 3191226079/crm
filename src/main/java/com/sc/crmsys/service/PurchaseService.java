package com.sc.crmsys.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sc.crmsys.bean.DetailPurchaseBean;
import com.sc.crmsys.bean.OrderPurchaseBean;
import com.sc.crmsys.bean.PurchaseBean;


public interface PurchaseService {
	
	List<PurchaseBean> getPurchase(String companyId);
	
	void addPurchase(PurchaseBean purchaseBean,DetailPurchaseBean detailPurchaseBean,OrderPurchaseBean orderPurchaseBean);
	
	List<PurchaseBean> findPurchase(String purchaseId);
	
}
