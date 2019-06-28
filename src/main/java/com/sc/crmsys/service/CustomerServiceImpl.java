package com.sc.crmsys.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sc.crmsys.bean.CustomerBean;
import com.sc.crmsys.mapper.CustomerBeanMapper;
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	
	@Resource
	private CustomerBeanMapper customerBeanMapper;

	@Override
	public List<CustomerBean> getCustomerId() {
		List<CustomerBean> getcustomerId = customerBeanMapper.getcustomerId();
		return getcustomerId;
	}

	

	

}
