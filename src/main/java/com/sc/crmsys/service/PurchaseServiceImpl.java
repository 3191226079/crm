package com.sc.crmsys.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sc.crmsys.bean.PurchaseBean;
import com.sc.crmsys.mapper.PurchaseBeanMapper;

@Service("purchaseService")
public class PurchaseServiceImpl implements PurchaseService{

	@Resource
	private PurchaseBeanMapper purchaseBeanMapper;
	
	@Override
	public PurchaseBean getPurchase(String purchaseId,String commodityNumber) {	
		PurchaseBean purchaseBean = purchaseBeanMapper.getByPrimaryKey(purchaseId, commodityNumber);
		return purchaseBean;
	}

}
