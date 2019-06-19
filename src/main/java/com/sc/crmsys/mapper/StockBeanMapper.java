package com.sc.crmsys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sc.crmsys.bean.StockBean;


public interface StockBeanMapper {
    int deleteByPrimaryKey(String commodityNumber);

    int insert(StockBean record);

    int insertSelective(StockBean record);

    StockBean selectByPrimaryKey(String commodityNumber);

    int updateByPrimaryKeySelective(StockBean record);

    int updateByPrimaryKey(StockBean record);
    
    List<StockBean> getPermissionByUserId(@Param("commodityNumber")String commodityNumber); 

}