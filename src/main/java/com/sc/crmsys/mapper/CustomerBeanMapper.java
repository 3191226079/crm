package com.sc.crmsys.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sc.crmsys.bean.CustomerBean;



public interface CustomerBeanMapper {
	
    void deleteByPrimaryKey(String customerId);

   public void insert(CustomerBean customer);

    int insertSelective(CustomerBean record);

    CustomerBean selectByPrimaryKey(String customerId);

    int updateByPrimaryKeySelective(CustomerBean record);

    int updateByPrimaryKey(CustomerBean record);
    
    public List<CustomerBean> selectToday(@Param("a")Date earlytime,@Param("b")Date latetime);
    
    
    public List<CustomerBean> selectthree(@Param("c")Date earlytime,@Param("d")Date latetime);
    public List<CustomerBean> selectseven(@Param("c")Date earlytime,@Param("d")Date latetime);
    public List<CustomerBean> selectonemonth(@Param("c")Date earlytime,@Param("d")Date latetime);
   
}