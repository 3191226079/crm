package com.sc.crmsys.service;

import java.util.List;

import com.sc.crmsys.bean.SupplierBean;

public interface SupplierService {
	
	List<SupplierBean> getSupplier();
	
	SupplierBean findSupplier(String supplierId);
	
	void updateSupplier(SupplierBean supplierBean);
	
	void updateSupplierState(String supplierId);
	
	void addSupplier(SupplierBean supplierBean);
	

}
