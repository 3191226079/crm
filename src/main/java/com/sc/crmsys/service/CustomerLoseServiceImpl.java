package com.sc.crmsys.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sc.crmsys.bean.CustomerLoseBean;
import com.sc.crmsys.mapper.CustomerLoseBeanMapper;

@Service("cutomerLoseService")
public class CustomerLoseServiceImpl implements CustomerLoseService{

	
	@Resource
	private CustomerLoseBeanMapper customerLoseBeanMapper;
	
	
	@Override
	public List<CustomerLoseBean> getcustomerlose() {
		List<CustomerLoseBean> getcustomerlose = customerLoseBeanMapper.getcustomerlose();
		
		return getcustomerlose;
	}


	@Override
	public CustomerLoseBean selectcustomerlose(String customerLoseId)
	{
		CustomerLoseBean selectByPrimaryKey = customerLoseBeanMapper.selectByPrimaryKey(customerLoseId);
		return selectByPrimaryKey;
	}


	@Override
	public void updatecustomerlose(CustomerLoseBean customerLoseBean) {
		customerLoseBeanMapper.updateByPrimaryKeySelective(customerLoseBean);
	
	}


	@Override
	public List<CustomerLoseBean> confirmationofloss() {
		List<CustomerLoseBean> confirmationofloss = customerLoseBeanMapper.confirmationofloss();
		
		return confirmationofloss;
	}


	


	
}
