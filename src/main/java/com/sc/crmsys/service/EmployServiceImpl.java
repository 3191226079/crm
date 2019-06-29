package com.sc.crmsys.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.EmployBean;
import com.sc.crmsys.bean.InfoBean;
import com.sc.crmsys.bean.JobBean;
import com.sc.crmsys.bean.RoleBean;
import com.sc.crmsys.bean.UserBean;
import com.sc.crmsys.bean.UserRoleBean;
import com.sc.crmsys.mapper.EmployBeanMapper;
import com.sc.crmsys.mapper.InfoDetailBeanMapper;
import com.sc.crmsys.mapper.JobBeanMapper;
import com.sc.crmsys.mapper.RoleBeanMapper;
import com.sc.crmsys.mapper.UserBeanMapper;
import com.sc.crmsys.mapper.UserRoleBeanMapper;

@Service("employServiceImpl")
public class EmployServiceImpl implements EmployService{
	
	@Resource
	private UserRoleBeanMapper userRoleBeanMapper;
	
	@Resource
	private RoleBeanMapper roleBeanMapper;
	
	@Resource
	private UserBeanMapper userBeanMapper;

	@Resource
	private JobBeanMapper jobBeanMapper;
	
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

	@Override
	public List<JobBean> selectAllJobll() {
		List<JobBean> jobList = jobBeanMapper.selectAllJobll();
		return jobList;
	}

	@Override
	public void insertEmployAndUser(EmployBean employBean, UserBean userBean, UserRoleBean userRoleBean) {
		employBeanMapper.insertSelective(employBean);
		userBeanMapper.insertSelective(userBean);
		userRoleBeanMapper.insertSelective(userRoleBean);
	}

	@Override
	public PageInfo<EmployBean> selectAllEmployAndUser(Integer pn, Integer size) {
		PageHelper.startPage(pn, size);
		List<EmployBean> employAndUserList = employBeanMapper.selectEmployAndUser();
		PageInfo<EmployBean> pageInfo = new PageInfo<EmployBean>(employAndUserList);
		return pageInfo;
	}

	@Override
	public EmployBean selectEmployById(String employId) {
		EmployBean employBean = employBeanMapper.selectEmployById(employId);
		return employBean;
	}

	@Override
	public void updateByPrimaryKeySelective(EmployBean record, String roleNumber) {
		employBeanMapper.updateByPrimaryKeySelective(record);
		userRoleBeanMapper.updateUserRole(record.getUserBean().getUserId(), roleNumber);
	}

	@Override
	public void deleteEmployAndUser(String employId) {
		userBeanMapper.updateUserState(employId);
		employBeanMapper.updateEmployState(employId);
	}

	@Override
	public List<RoleBean> selectAllRole() {
		List<RoleBean> roleList = roleBeanMapper.selectAllRole();
		return roleList;
	}

}
