package com.sc.crmsys.service;

import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.CustomerBean;

public interface CustomerService {

	
	public PageInfo<CustomerBean> selectAll(Integer pn,Integer size,CustomerBean customerBean);
	
	
	public CustomerBean get1(String customerId);
	
	public void update(CustomerBean customerBean);
	
	public void del(String customerId);
	 
}
