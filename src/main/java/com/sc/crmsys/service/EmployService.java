package com.sc.crmsys.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.EmployBean;
import com.sc.crmsys.bean.InfoBean;
import com.sc.crmsys.bean.JobBean;
import com.sc.crmsys.bean.RoleBean;
import com.sc.crmsys.bean.UserBean;
import com.sc.crmsys.bean.UserRoleBean;

public interface EmployService {

	public  List<EmployBean> selectAllEmploy();
	
	public PageInfo<EmployBean> employInfo(int pn,int size,String content);
	
	public String selectJobId(String jobName);
	
	public void updateJob(EmployBean record);

	public EmployBean selectByPrimaryKey(String employId);
	
	public EmployBean selectInfo(InfoBean infoBean,String employId);
	
	public void deleteByPrimaryKey(String employId);
	
	public void update(String employId);
	
	public List<JobBean> selectAllJobll();
	
	public void insertEmployAndUser(EmployBean employBean, UserBean userBean, UserRoleBean userRoleBean);
	
	public PageInfo<EmployBean> selectAllEmployAndUser(Integer pn, Integer size);
	
	public EmployBean selectEmployById(String employId);
	
	public void updateByPrimaryKeySelective(EmployBean record, String roleNumber);
	
	public void deleteEmployAndUser(String employId);
	
	public List<RoleBean> selectAllRole();
}
