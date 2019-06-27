package com.sc.crmsys.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sc.crmsys.bean.EmployBean;
import com.sc.crmsys.bean.InfoBean;
import com.sc.crmsys.mapper.EmployBeanMapper;
import com.sc.crmsys.mapper.InfoDetailBeanMapper;

@Service("employServiceImpl")
public class EmployServiceImpl implements EmployService{

	@Resource
	private EmployBeanMapper employBeanMapper;
	
	@Resource
	private InfoDetailBeanMapper infoDetailBeanMapper;
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

	@Override
	public EmployBean selectInfo(InfoBean infoBean,String employId) {
		EmployBean selectInfo = employBeanMapper.selectInfo(infoBean,employId);
		return selectInfo;
	}

	@Override
	public void deleteByPrimaryKey(String employId) {
		employBeanMapper.deleteByPrimaryKey(employId);
	}

	@Override
	public void update(String employId) {
		infoDetailBeanMapper.update(employId);
	}

}
