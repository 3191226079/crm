package com.sc.crmsys.service;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sc.crmsys.bean.SaleInfoBean;
import com.sc.crmsys.bean.StockBean;
import com.sc.crmsys.mapper.SaleInfoBeanMapper;
import com.sc.crmsys.mapper.StockBeanMapper;

@Service("stockService")
public class StockServiceImpl implements  StockService{

	@Resource
	private StockBeanMapper stockBeanMapper;

	
	@Resource
	private SaleInfoBeanMapper saleInfoBeanMapper;
	



	@Override
	public List<StockBean> getStockes() {
		List<StockBean> stockList = stockBeanMapper.getStockList();
		
		return stockList;
	}

	@Override
	public void addStock(StockBean stockBean) {
		stockBeanMapper.insert(stockBean);
		
	}

	@Override
	public List<StockBean> selectStock() {
		List<StockBean> selectStock = stockBeanMapper.selectStock();
		return selectStock;
	}

	@Override
	public StockBean selectByPrimaryKey(String commodityNumber) {
		StockBean selectByPrimaryKey = stockBeanMapper.selectByPrimaryKey(commodityNumber);
		return selectByPrimaryKey;
	}

	@Override
	public void deleteByPrimaryKey(String commodityNumber) {
		stockBeanMapper.deleteByPrimaryKey(commodityNumber);
	}

	@Override
	public void updateStockId(StockBean stockBean,SaleInfoBean saleInfoBean) {
		stockBeanMapper.updateByPrimaryKeySelective(stockBean);
		String saleinfoId = UUID.randomUUID().toString();
		saleInfoBean.setSaleinfoId(saleinfoId);
		saleInfoBeanMapper.insert(saleInfoBean);
		
		
		
	}

	@Override
	public List<StockBean> getStock() {
		List<StockBean> getStock = stockBeanMapper.selectStock();
		return getStock;
	}
	//查询价格
	@Override
	public StockBean selectStockPrice(String commodityNumber)
	{
		StockBean price = stockBeanMapper.selectByPrimaryKey(commodityNumber);
		return price;
	}

	
	
	
	

	

	
	
	public StockBean getStock(String commodityNumber) {
		StockBean stockBean = stockBeanMapper.selectByPrimaryKey(commodityNumber);
		return stockBean;
	}

	@Override
	public List<StockBean> getPurchase(String companyId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
