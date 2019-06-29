package com.sc.crmsys.service;

import java.util.List;

import com.sc.crmsys.bean.StockBean;

public interface StockService {
	
	List<StockBean> getStockes();
	
	StockBean getStock(String commodityNumber);
	
	
	
	
	

}
