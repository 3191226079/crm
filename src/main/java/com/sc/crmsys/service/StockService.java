package com.sc.crmsys.service;

import java.util.List;

import com.github.pagehelper.Page;
import com.sc.crmsys.bean.StockBean;


public interface StockService {
	public List<StockBean> list();
	
	public String total();
	
	public List<StockBean> list(Page page);
	
	public void addStock(StockBean stockBean);
	
	public void deleteStock(StockBean stockBean);
	
	public void updateStock(StockBean stockBean);
	//查询单条
	public StockBean getStock(String commodityNumber);
	//查询所有
	public List<StockBean> stockList();
	
	

}
