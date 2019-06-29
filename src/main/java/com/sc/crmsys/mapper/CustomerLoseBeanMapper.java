package com.sc.crmsys.mapper;

import java.util.List;

import com.sc.crmsys.bean.CustomerBean;
import com.sc.crmsys.bean.CustomerLoseBean;

public interface CustomerLoseBeanMapper {
    void deleteByPrimaryKey(String customerLoseId);

    int insert(CustomerLoseBean record);

    int insertSelective(CustomerLoseBean record);

    CustomerLoseBean selectByPrimaryKey(String customerLoseId);

    void updateByPrimaryKeySelective(CustomerLoseBean customerLoseBean);

    int updateByPrimaryKey(CustomerLoseBean record);
   
    public List<CustomerLoseBean> getcustomerlose();
    
    
    public List<CustomerLoseBean> confirmationofloss();
    
    public void setcustomerlose();
    //查询客户编号
    public CustomerLoseBean getcustomerIdInfo();
    
    public List<CustomerLoseBean> selectlose();
}