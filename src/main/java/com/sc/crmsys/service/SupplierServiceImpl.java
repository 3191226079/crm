package com.sc.crmsys.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sc.crmsys.bean.SupplierBean;
import com.sc.crmsys.mapper.SupplierBeanMapper;

@Service("supplierService")
public class SupplierServiceImpl implements SupplierService{

	@Resource
	private SupplierBeanMapper supplierBeanMapper;
	
	@Override
	public List<SupplierBean> getSupplier() {
		
		List<SupplierBean> supplierList = supplierBeanMapper.getSupplier();
		
		return supplierList;
	}

	@Override
	public SupplierBean findSuplier(String supplierId) {
		SupplierBean supplier = supplierBeanMapper.selectByPrimaryKey(supplierId);
		return supplier;
	}

}
