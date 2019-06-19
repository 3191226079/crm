package com.sc.crmsys.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sc.crmsys.bean.CustomerBean;
import com.sc.crmsys.mapper.CustomerBeanMapper;

@Service
public class ContactServiceImpl implements ContactService{

	@Resource
	private CustomerBeanMapper customerMapper;
		
	@Override
	public void addCustomerInfo(CustomerBean customer) {
		customerMapper.insert(customer);
		
	}

}
