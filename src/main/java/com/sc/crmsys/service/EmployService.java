package com.sc.crmsys.service;

import java.util.List;

import com.sc.crmsys.bean.EmployBean;

public interface EmployService {

	public  List<EmployBean> selectAllEmploy();
	
	public EmployBean selectByPrimaryKey(String employId);
}
