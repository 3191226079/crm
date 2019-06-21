package com.sc.crmsys.service;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
	
	@Resource
	private OrderPurchaseBeanMapper orderPurchaseBeanMapper;

	@Override
	public List<PurchaseBean> getPurchase(String companyId) {
		List<PurchaseBean> purchaselist = purchaseBeanMapper.getByPrimaryKey(companyId);
		return purchaselist;
	}

	@Override
	public void addPurchase(PurchaseBean purchaseBean,DetailPurchaseBean detailPurchaseBean,OrderPurchaseBean orderPurchaseBean)
 {
		
		
		//插入数据
		purchaseBeanMapper.insert(purchaseBean);
		
		detailPurchaseBeanMapper.insert(detailPurchaseBean);
		
		orderPurchaseBeanMapper.insert(orderPurchaseBean);
		
	}

	

	@Override
	public List<PurchaseBean> findPurchase(String purchaseId) {
		List<PurchaseBean> list = purchaseBeanMapper.findByPrimaryKey(purchaseId);
		return list;
	}


	
	

}
