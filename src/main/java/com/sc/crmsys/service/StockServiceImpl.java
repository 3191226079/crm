package com.sc.crmsys.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.sc.crmsys.bean.StockBean;
import com.sc.crmsys.mapper.StockBeanMapper;

@Service("StockService")
public class StockServiceImpl implements StockService{
	
	@Resource
	private StockBeanMapper stockBeanMapper;

	@Override
	public List<StockBean> list() {
		return stockBeanMapper.list();
	}

	@Override
	public String total() {
		return stockBeanMapper.total();
	}

	@Override
	public List<StockBean> list(Page page) {
		return stockBeanMapper.list(page);
	}

	@Override
	public void addStock(StockBean stockBean) {
		stockBeanMapper.addStock(stockBean);
		
	}

	@Override
	public void deleteStock(StockBean stockBean) {
		stockBeanMapper.deleteStock(stockBean);
		
	}

	@Override
	public void updateStock(StockBean stockBean) {
		stockBeanMapper.updateStock(stockBean);
		
	}

	@Override
	public StockBean getStock(String commodityNumber) {
		return null;
		
		/*return stockBeanMapper.getStock(String commodityNumber);*/
	}

	@Override
	public List<StockBean> stockList() {
		return stockBeanMapper.stockList();
	}

	
}
