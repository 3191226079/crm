package com.sc.crmsys.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sc.crmsys.bean.WarehouseBean;
import com.sc.crmsys.mapper.WarehouseBeanMapper;

@Service("warehouseService")
public class WarehouseServiceImpl implements WarehouseService {

	@Resource
	private WarehouseBeanMapper warehouseBeanMapper;
	
	@Override
	public WarehouseBean getWarehouseName(String warehouseNumber) {
		WarehouseBean warehouseBean = warehouseBeanMapper.selectByPrimaryKey(warehouseNumber);
		return warehouseBean;
	}

}
