package com.sc.crmsys.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sc.crmsys.bean.StockBean;
import com.sc.crmsys.mapper.StockBeanMapper;

@Service("stockService")
public class StockServiceImpl implements  StockService{

	@Resource
	private StockBeanMapper stockBeanMapper;
	
	@Override
	public List<StockBean> getPurchase(String companyId) {
		/*List<StockBean> list = stockBeanMapper.getByPrimaryKey(companyId);*/
		return null;
	}

}
