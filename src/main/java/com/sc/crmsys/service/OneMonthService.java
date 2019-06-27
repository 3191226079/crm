package com.sc.crmsys.service;

import java.util.List;

import com.sc.crmsys.bean.CustomerBean;

public interface OneMonthService {
	public List<CustomerBean> getonemonth();
	
	public void delom(String customerId);

}
