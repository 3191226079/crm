package com.sc.crmsys.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.CustomerBean;

public interface SevenDayService {
	public List<CustomerBean> getsevenday();
	
	public void delsevenday(String customerId);
	public PageInfo<CustomerBean> selectAll(Integer pn,Integer size,CustomerBean customerBean);
}
