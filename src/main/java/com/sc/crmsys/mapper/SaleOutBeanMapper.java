package com.sc.crmsys.mapper;

import java.util.List;

import com.sc.crmsys.bean.CustomerBean;
import com.sc.crmsys.bean.SaleOutBean;

public interface SaleOutBeanMapper {
    void deleteByPrimaryKey(String saleoutId);

    void insert(SaleOutBean record);

    int insertSelective(SaleOutBean record);

    SaleOutBean selectByPrimaryKey(String saleoutId);

   void updateByPrimaryKeySelective(SaleOutBean record);

    int updateByPrimaryKey(SaleOutBean record);
    
    public List<SaleOutBean> getsaleout();
    
    //查询销售单编号
    List<SaleOutBean>  getSaleOutId();
    
    List<SaleOutBean>  seletStockSaleout();
    
    //测试查询
    List<SaleOutBean> selectSS();
    
    
    
 
}