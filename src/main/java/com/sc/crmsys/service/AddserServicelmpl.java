package com.sc.crmsys.service;


import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.CustomerBean;
import com.sc.crmsys.mapper.CustomerBeanMapper;


@Service("add1service")
public class AddserServicelmpl implements Addservice{
	
	
	@Resource
	private CustomerBeanMapper customerBeanMapper;

	@Override
	public void add(CustomerBean customer) {
		String token = UUID.randomUUID().toString();
		customer.setCustomerId(token);
		customerBeanMapper.insertSelective(customer);
		
		
	}

	


	

	

	
}
