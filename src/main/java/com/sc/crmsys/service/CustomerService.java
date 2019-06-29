package com.sc.crmsys.service;


import java.util.List;

import com.sc.crmsys.bean.CustomerBean;

	

import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.CustomerBean;

public interface CustomerService {
	
	//查客户编号
	public List<CustomerBean>  getcustomerIdInfo();

	
	public PageInfo<CustomerBean> selectAll(Integer pn,Integer size,CustomerBean customerBean);
	
	
	public CustomerBean get1(String customerId);
	
	public void update(CustomerBean customerBean);
	
	public void del(String customerId);
}
