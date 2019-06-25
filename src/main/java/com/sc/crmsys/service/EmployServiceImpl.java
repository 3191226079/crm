package com.sc.crmsys.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sc.crmsys.bean.EmployBean;
import com.sc.crmsys.mapper.EmployBeanMapper;

@Service("employServiceImpl")
public class EmployServiceImpl implements EmployService{

	@Resource
	private EmployBeanMapper employBeanMapper;
	@Override
	public List<EmployBean> selectAllEmploy() {
		List<EmployBean> employList = employBeanMapper.selectAllEmploy();
		return employList;
	}
	
	@Override
	public EmployBean selectByPrimaryKey(String employId) {
		EmployBean employBean = employBeanMapper.selectByPrimaryKey(employId);
		return employBean;
	}

}
