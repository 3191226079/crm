package com.sc.crmsys.service;

import java.util.List;

import com.sc.crmsys.bean.SupplierBean;

public interface SupplierService {
	
	List<SupplierBean> getSupplier();
	
	SupplierBean findSuplier(String supplierId);
	

}
