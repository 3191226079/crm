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

@Service("sevendayservice")
public class SevenDayServicelmpl implements SevenDayService{

	@Resource
	private CustomerBeanMapper  customerBeanMapper;
	
	
	
	@Override
	public List<CustomerBean> getsevenday() {
		Date setsevenearly = MyUtils.setsevenearly();
		Date setlater = MyUtils.setlater();
		List<CustomerBean> selectseven = customerBeanMapper.selectseven(setsevenearly, setlater);
		
		return selectseven;
	}



	@Override
	public void delsevenday(String customerId) {
		customerBeanMapper.deleteByPrimaryKey(customerId);
		
	}



	@Override
	public PageInfo<CustomerBean> selectAll(Integer pn, Integer size, CustomerBean customerBean) {
		PageHelper.startPage(pn, size);
		Date setsevenearly = MyUtils.setsevenearly();
       Date setearly = MyUtils.setearly();
		Date setlater = MyUtils.setlater();
		List<CustomerBean> CustomerBean = customerBeanMapper.selectToday(setsevenearly, setlater);
		PageInfo<CustomerBean> pageInfo = new PageInfo<CustomerBean>(CustomerBean);
		return pageInfo;
	}

}
