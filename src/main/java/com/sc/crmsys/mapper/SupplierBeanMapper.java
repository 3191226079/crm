package com.sc.crmsys.mapper;

import java.util.List;

import com.sc.crmsys.bean.SupplierBean;

public interface SupplierBeanMapper {
    int deleteByPrimaryKey(String supplierId);

    int insert(SupplierBean record);

    int insertSelective(SupplierBean record);

    SupplierBean selectByPrimaryKey(String supplierId);

    int updateByPrimaryKeySelective(SupplierBean record);

    int updateByPrimaryKey(SupplierBean record);
    
    List<SupplierBean> getSupplier();
    
    void updateState(String supplierId);
}