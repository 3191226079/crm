package com.sc.crmsys.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sc.crmsys.bean.DetailPurchaseBean;
import com.sc.crmsys.mapper.DetailPurchaseBeanMapper;

@Service("detailPurchaseService")
public class DetailPurchaseServiceImpl implements DetailPurchaseService{
	
	@Resource
	private DetailPurchaseBeanMapper detailPurchaseBeanMapper;

	@Override
	public void addDetail(DetailPurchaseBean detailPurchaseBean) {
		
		detailPurchaseBeanMapper.insertSelective(detailPurchaseBean);
	}

}
