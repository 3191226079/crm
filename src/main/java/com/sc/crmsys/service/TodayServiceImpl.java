package com.sc.crmsys.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.CustomerBean;

import com.sc.crmsys.mapper.CustomerBeanMapper;
import com.sc.crmsys.utils.MyUtils;

@Service("Todayservice")
public class TodayServiceImpl implements TodayService{

	
	@Resource
	private CustomerBeanMapper customerBeanMapper;
	
	
	@Override
	public List<CustomerBean> selectToday() {

		
		
		Date setearly = MyUtils.setearly();
		
		Date setlater = MyUtils.setlater();
		
	
		List<CustomerBean> selectToday = customerBeanMapper.selectToday(setearly, setlater);
	
		
		return selectToday;
	}


	@Override
	public void deltoday(String customerId) {
		customerBeanMapper.deleteByPrimaryKey(customerId);
		
	}


	@Override
	public PageInfo<CustomerBean> selectAll(Integer pn, Integer size, CustomerBean customerBean) {
		PageHelper.startPage(pn, size);
       Date setearly = MyUtils.setearly();
		Date setlater = MyUtils.setlater();
		List<CustomerBean> CustomerBean = customerBeanMapper.selectToday(setearly, setlater);
		PageInfo<CustomerBean> pageInfo = new PageInfo<CustomerBean>(CustomerBean);
		return pageInfo;
	}

}
