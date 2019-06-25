package com.sc.crmsys.service;

import java.util.List;

import com.sc.crmsys.bean.StockBean;

public interface StockService {
	
	List<StockBean> getPurchase(String companyId);
	//添加商品
	public void addStock(StockBean stockBean);
	//查询库存
	public List<StockBean> selectStock();
	//查询Id
	public StockBean selectByPrimaryKey(String commodityNumber);
	//通过Id删除商品信息
	public void deleteByPrimaryKey(String commodityNumber);
	//修改
	public void updateStockId(StockBean stockBean);
	
	
	
	
	

}
