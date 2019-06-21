package com.sc.crmsys.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sc.crmsys.bean.DetailPurchaseBean;
import com.sc.crmsys.bean.OrderPurchaseBean;
import com.sc.crmsys.bean.PurchaseBean;
import com.sc.crmsys.mapper.DetailPurchaseBeanMapper;
import com.sc.crmsys.mapper.OrderPurchaseBeanMapper;
import com.sc.crmsys.mapper.PurchaseBeanMapper;

@Service("purchaseService")
public class PurchaseServiceImpl implements PurchaseService{

	@Resource
	private PurchaseBeanMapper purchaseBeanMapper;
	
	@Resource
	private DetailPurchaseBeanMapper detailPurchaseBeanMapper;
	
	private OrderPurchaseBeanMapper orderPurchaseBeanMapper;

	@Override
	public List<PurchaseBean> getPurchase(String companyId) {
		List<PurchaseBean> list = purchaseBeanMapper.getByPrimaryKey(companyId);
		return list;
	}

	@Override
	public void addPurchase(PurchaseBean purchaseBean,DetailPurchaseBean detailPurchaseBean,OrderPurchaseBean orderPurchaseBean)
 {
		purchaseBeanMapper.insert(purchaseBean);
		
		detailPurchaseBeanMapper.insert(detailPurchaseBean);
		
		orderPurchaseBeanMapper.insert(orderPurchaseBean);
		
	}
	
	

}
