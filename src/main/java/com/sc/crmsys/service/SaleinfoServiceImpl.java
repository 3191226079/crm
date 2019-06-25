package com.sc.crmsys.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sc.crmsys.bean.SaleInfoBean;
import com.sc.crmsys.mapper.SaleInfoBeanMapper;

@Service("saleinfoService")
public class SaleinfoServiceImpl implements SaleinfoService{

	@Resource
	private SaleInfoBeanMapper saleInfoBeanMapper;
	
	@Override
	public List<SaleInfoBean> getsaleinfo() {
		List<SaleInfoBean> getsaleinfo = saleInfoBeanMapper.getsaleinfo();
		
		return getsaleinfo;
	}

	@Override
	public void addsaleinfo(SaleInfoBean saleInfoBean) {
		saleInfoBeanMapper.insert(saleInfoBean);
		
	}

	@Override
	public SaleInfoBean get1saleinfo(String saleinfoId) {
		SaleInfoBean selectByPrimaryKey = saleInfoBeanMapper.selectByPrimaryKey(saleinfoId);
		System.out.println(selectByPrimaryKey);
		return selectByPrimaryKey;
	}

	@Override
	public void updatesaleinfo(SaleInfoBean saleInfoBean) {
		System.out.println(saleInfoBean);
		saleInfoBeanMapper.updateByPrimaryKeySelective(saleInfoBean);
		
	}

	@Override
	public void delsaleinfo(String saleinfoId) {
		saleInfoBeanMapper.deleteByPrimaryKey(saleinfoId);
		
	}
	

}
