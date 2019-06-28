package com.sc.crmsys.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.EmployBean;
import com.sc.crmsys.bean.InfoBean;

public interface EmployService {

	public  List<EmployBean> selectAllEmploy();
	
	public PageInfo<EmployBean> employInfo(int pn,int size,String content);
	
	public String selectJobId(String jobName);
	
	public void updateJob(EmployBean record);

	public EmployBean selectByPrimaryKey(String employId);
	
	public EmployBean selectInfo(InfoBean infoBean,String employId);
	
	public void deleteByPrimaryKey(String employId);
	
	public void update(String employId);
}
