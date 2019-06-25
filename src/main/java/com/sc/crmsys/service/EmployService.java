package com.sc.crmsys.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.EmployBean;

public interface EmployService {

	public  List<EmployBean> selectAllEmploy();
	
	public PageInfo<EmployBean> eamployInfo(int pn,int size,String content);
	
	public String selectJobId(String jobName);
	
	public void updateJob(EmployBean record);
}
