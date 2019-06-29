package com.sc.crmsys.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.CustomerBean;

public interface ThreeDayService {
     public List<CustomerBean> getthreeday();
     public void delthreeday(String customerId);
     public PageInfo<CustomerBean> selectAll(Integer pn,Integer size,CustomerBean customerBean);
}
