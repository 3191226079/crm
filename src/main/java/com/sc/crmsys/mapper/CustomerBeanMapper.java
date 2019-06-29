package com.sc.crmsys.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sc.crmsys.bean.CustomerBean;



public interface CustomerBeanMapper {
	
    void deleteByPrimaryKey(String customerId);

   public void insert(CustomerBean customer);

    int insertSelective(CustomerBean record);

    CustomerBean selectByPrimaryKey(String customerId);

    void updateByPrimaryKeySelective(CustomerBean record);

    int updateByPrimaryKey(CustomerBean record);
    
    
    public ArrayList<String> getcustomerid();
    
    public  void add(@Param("a")String getcustomerid,@Param("b")String token);
    
    
    
    public ArrayList<String> getcustomerloseid();
    
  
    
    
    
    
    List<CustomerBean>  selectall(CustomerBean customerBean);
    
    public List<CustomerBean> selectToday(@Param("a")Date earlytime,@Param("b")Date latetime);
    
    
    public List<CustomerBean> selectthree(@Param("c")Date earlytime,@Param("d")Date latetime);
    public List<CustomerBean> selectseven(@Param("c")Date earlytime,@Param("d")Date latetime);
    public List<CustomerBean> selectonemonth(@Param("c")Date earlytime,@Param("d")Date latetime);
   
}