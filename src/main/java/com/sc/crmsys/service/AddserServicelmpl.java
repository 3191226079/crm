package com.sc.crmsys.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sc.crmsys.bean.CustomerBean;
import com.sc.crmsys.mapper.CustomerBeanMapper;


@Service("addservice")
public class AddserServicelmpl implements Addservice{
	
	
	@Resource
	private CustomerBeanMapper customerBeanMapper;

	@Override
	public void add(CustomerBean customer) {
		
		customerBeanMapper.insert(customer);
	}

	
}
