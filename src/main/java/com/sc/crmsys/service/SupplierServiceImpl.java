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
	public SupplierBean findSupplier(String supplierId) {
		SupplierBean supplier = supplierBeanMapper.selectByPrimaryKey(supplierId);
		return supplier;
	}

	@Override
	public void updateSupplier(SupplierBean supplierBean) {
		supplierBeanMapper.updateByPrimaryKeySelective(supplierBean);
		
	}

	@Override
	public void updateSupplierState(String supplierId) {
		supplierBeanMapper.updateState(supplierId);
		
	}

	@Override
	public void addSupplier(SupplierBean supplierBean) {
		supplierBeanMapper.insert(supplierBean);
		
	}

}
