package com.sc.crmsys.service;

import java.util.List;

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

	@Override
	public WarehouseBean selectWarehouseNumber(String warehouseNumber) {
		WarehouseBean selectWarehouseNumber = warehouseBeanMapper.selectWarehouseNumber(warehouseNumber);
		return selectWarehouseNumber;
	}

	@Override
	public List<WarehouseBean> selectWarehouse()
	{
		List<WarehouseBean> selectWarehouse = warehouseBeanMapper.selectWarehouse();
		return selectWarehouse;
	}


	


	

}
