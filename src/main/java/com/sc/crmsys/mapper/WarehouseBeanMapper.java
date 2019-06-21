package com.sc.crmsys.mapper;

import com.sc.crmsys.bean.WarehouseBean;

public interface WarehouseBeanMapper {
    int deleteByPrimaryKey(String warehouseNumber);

    int insert(WarehouseBean record);

    int insertSelective(WarehouseBean record);

    WarehouseBean selectByPrimaryKey(String warehouseNumber);

    int updateByPrimaryKeySelective(WarehouseBean record);

    int updateByPrimaryKey(WarehouseBean record);
    
    public void selectWarehouseName(String warehouseName);
}