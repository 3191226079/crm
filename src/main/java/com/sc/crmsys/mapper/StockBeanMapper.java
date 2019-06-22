package com.sc.crmsys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.github.pagehelper.Page;
import com.sc.crmsys.bean.StockBean;


public interface StockBeanMapper {
    int deleteByPrimaryKey(String commodityNumber);

    int insert(StockBean record);

    int insertSelective(StockBean record);

    StockBean selectByPrimaryKey(String commodityNumber);
 
    int updateByPrimaryKeySelective(StockBean record);

    int updateByPrimaryKey(StockBean record);
    //查询库存
    List<StockBean> selectStock();
    
}