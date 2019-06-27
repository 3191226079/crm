package com.sc.crmsys.service;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.CustomerBean;
import com.sc.crmsys.mapper.CustomerBeanMapper;

@Service("customerService")
public class CustomerServiceImpl  implements CustomerService{

	
	@Resource
	private CustomerBeanMapper customerBeanMapper;
	
	@Override
	public PageInfo<CustomerBean> selectAll(Integer pn, Integer size, CustomerBean customerBean) {
		PageHelper.startPage(pn, size);
		String token = UUID.randomUUID().toString();
		customerBean.setCustomerId(token);
		List<CustomerBean> selectall = customerBeanMapper.selectall(customerBean);
		PageInfo<CustomerBean> pageInfo = new PageInfo<CustomerBean>(selectall);
		
		
		return pageInfo;
	}

	@Override
	public CustomerBean get1(String customerId) {
		CustomerBean selectByPrimaryKey = customerBeanMapper.selectByPrimaryKey(customerId);
		
		return selectByPrimaryKey;
	}

	@Override
	public void update(CustomerBean customerBean) {
		customerBeanMapper.updateByPrimaryKeySelective(customerBean);
		
	}

	@Override
	public void del(String customerId) {
		customerBeanMapper.deleteByPrimaryKey(customerId);
		
	}

}
