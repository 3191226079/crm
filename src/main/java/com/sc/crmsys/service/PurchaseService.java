package com.sc.crmsys.service;

import com.sc.crmsys.bean.PurchaseBean;

public interface PurchaseService {
	
	PurchaseBean getPurchase(String purchaseId,String commodityNumber);

}
