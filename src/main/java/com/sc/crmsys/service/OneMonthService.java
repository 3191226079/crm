package com.sc.crmsys.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.CustomerBean;

public interface OneMonthService {
	public List<CustomerBean> getonemonth();
	
	public void delom(String customerId);
	public PageInfo<CustomerBean> selectAll(Integer pn,Integer size,CustomerBean customerBean);
}
