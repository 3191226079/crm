package com.sc.crmsys.mapper;

import java.util.List;



import com.github.pagehelper.Page;
import com.sc.crmsys.bean.StockBean;


public interface StockBeanMapper {
    int deleteByPrimaryKey(String commodityNumber);

    int insert(StockBean record);

    int insertSelective(StockBean record);

    StockBean selectByPrimaryKey(String commodityNumber);
 
    int updateByPrimaryKeySelective(StockBean record);

    int updateByPrimaryKey(StockBean record);
    
    public List<StockBean> list();
    //分页查询
    public List<StockBean> list(Page page);
    
    public String total();
    //添加
    public void addStock(StockBean stockBean);
    //删除
    public void deleteStock(StockBean stockBean);
    //修改
    public void updateStock(StockBean stockBean);
    //查询单条
    public StockBean getStock(StockBean stockBean);
    //查询所有
    public List<StockBean> stockList();
    
    
}