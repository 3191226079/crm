package com.sc.crmsys.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import com.sc.crmsys.bean.DetailPurchaseBean;
import com.sc.crmsys.bean.OrderPurchaseBean;
import com.sc.crmsys.bean.PurchaseBean;
import com.sc.crmsys.bean.StockBean;
import com.sc.crmsys.mapper.DetailPurchaseBeanMapper;
import com.sc.crmsys.mapper.OrderPurchaseBeanMapper;
import com.sc.crmsys.mapper.PurchaseBeanMapper;
import com.sc.crmsys.mapper.StockBeanMapper;

@Service("purchaseService")
public class PurchaseServiceImpl implements PurchaseService{

	@Resource
	private PurchaseBeanMapper purchaseBeanMapper;
	
	@Resource
	private DetailPurchaseBeanMapper detailPurchaseBeanMapper;
	
	@Resource
	private OrderPurchaseBeanMapper orderPurchaseBeanMapper;
	
	@Resource
	private StockBeanMapper stockBeanMapper;

	@Override
	public List<PurchaseBean> getPurchase() {
		List<PurchaseBean> purchaselist = purchaseBeanMapper.getByPrimaryKey();
		return purchaselist;
	}

	@Override
	public void addPurchase(PurchaseBean purchaseBean)
 {
		//插入数据
		purchaseBeanMapper.insert(purchaseBean);
	}

	

	@Override
	public List<PurchaseBean> findPurchase(String purchaseId) {
		List<PurchaseBean> list = purchaseBeanMapper.findByPrimaryKey(purchaseId);
		return list;
	}

	@Override
	public void updatePurchase(PurchaseBean purchaseBean, DetailPurchaseBean detailPurchaseBean,
			OrderPurchaseBean orderPurchaseBean) {
		
		
		
		purchaseBeanMapper.update(purchaseBean);
		
		detailPurchaseBeanMapper.update(detailPurchaseBean);
	
		orderPurchaseBeanMapper.update(orderPurchaseBean);
		
	}

	@Override
	public void updatePurchaseState(String purchaseId,@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")Date purchaseUpdateTime) {
		purchaseBeanMapper.updateState(purchaseId,purchaseUpdateTime);
		
	}

	@Override
	public List<PurchaseBean> selcetPurchaseAll(PurchaseBean purchaseBean) {
		List<PurchaseBean> selectPurchase = purchaseBeanMapper.selectPurchase(purchaseBean);
		return selectPurchase;
	}






	


	
	

}
