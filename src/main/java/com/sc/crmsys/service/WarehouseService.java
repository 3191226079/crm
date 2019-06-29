package com.sc.crmsys.service;

import java.util.List;

import com.sc.crmsys.bean.StockBean;
import com.sc.crmsys.bean.WarehouseBean;

public interface WarehouseService {
	
	WarehouseBean getWarehouseName(String warehouseNumber);
	
	public WarehouseBean selectWarehouseNumber(String warehouseNumber);
	
	public List<WarehouseBean> selectWarehouse();
	
	
	

}
