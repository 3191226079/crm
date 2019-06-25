package com.sc.crmsys.mapper;

import java.util.List;

import com.sc.crmsys.bean.SaleInfoBean;

public interface SaleInfoBeanMapper {
    void deleteByPrimaryKey(String saleinfoId);

    void insert(SaleInfoBean record);

    int insertSelective(SaleInfoBean record);

    SaleInfoBean selectByPrimaryKey(String saleinfoId);

    void updateByPrimaryKeySelective(SaleInfoBean record);

    int updateByPrimaryKey(SaleInfoBean record);
    
    public List<SaleInfoBean> getsaleinfo();
}