package com.sc.crmsys.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.CustomerBean;
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


	@Override

	public List<CustomerLoseBean> getSelectCustomerlose() {
		List<CustomerLoseBean> getcustomerlose = customerLoseBeanMapper.getcustomerlose();
		return getcustomerlose;
	}

	public void del(String customerLoseId) {
		customerLoseBeanMapper.deleteByPrimaryKey(customerLoseId);
		
	}


	@Override
	public PageInfo<CustomerLoseBean> selectAll(Integer pn, Integer size, CustomerLoseBean customerLoseBean) {
		PageHelper.startPage(pn, size);
		List<CustomerLoseBean> getcustomerlose = customerLoseBeanMapper.getcustomerlose();
		PageInfo<CustomerLoseBean> pageInfo = new PageInfo<CustomerLoseBean>(getcustomerlose);	
		return pageInfo;
	}


	@Override
	public PageInfo<CustomerLoseBean> selectAll1(Integer pn, Integer size, CustomerLoseBean customerLoseBean) {
		PageHelper.startPage(pn, size);
		List<CustomerLoseBean> getcustomerlose = customerLoseBeanMapper.confirmationofloss();
		PageInfo<CustomerLoseBean> pageInfo = new PageInfo<CustomerLoseBean>(getcustomerlose);	
		return pageInfo;
	}


	@Override
	public PageInfo<CustomerLoseBean> selectlose(Integer pn, Integer size, CustomerLoseBean customerLoseBean) {
		PageHelper.startPage(pn, size);
		List<CustomerLoseBean> selectlose = customerLoseBeanMapper.selectlose();
		PageInfo<CustomerLoseBean> pageInfo = new PageInfo<CustomerLoseBean>(selectlose);
		return pageInfo;
	}




	

	
	
	
	
	
	
	
	
	



	


	
}
