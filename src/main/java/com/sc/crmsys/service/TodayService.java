package com.sc.crmsys.service;



import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.CustomerBean;


public interface TodayService {
	public List<CustomerBean> selectToday();
	public void deltoday(String customerId);
	public PageInfo<CustomerBean> selectAll(Integer pn,Integer size,CustomerBean customerBean);

}
