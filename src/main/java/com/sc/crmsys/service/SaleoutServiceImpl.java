package com.sc.crmsys.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sc.crmsys.bean.SaleOutBean;
import com.sc.crmsys.mapper.SaleOutBeanMapper;

@Service("saleoutService")
public class SaleoutServiceImpl implements SaleoutService{
	
	@Resource
	private SaleOutBeanMapper saleOutBeanMapper;

	@Override
	public List<SaleOutBean> getsaleout() {
		List<SaleOutBean> getsaleout = saleOutBeanMapper.getsaleout();
		return getsaleout;
	}

	@Override
	public void addsaleout(SaleOutBean saleOutBean) {
		saleOutBeanMapper.insert(saleOutBean);
		
	}

	@Override
	public SaleOutBean get1ssaleout(String saleoutId) {
		SaleOutBean selectByPrimaryKey = saleOutBeanMapper.selectByPrimaryKey(saleoutId);
		return selectByPrimaryKey;
	}

	@Override
	public void updatesaleout(SaleOutBean saleOutBean) {
		saleOutBeanMapper.updateByPrimaryKeySelective(saleOutBean);
		
	}

	@Override
	public void delsaleout(String saleoutId) {
		saleOutBeanMapper.deleteByPrimaryKey(saleoutId);	
	}

}
