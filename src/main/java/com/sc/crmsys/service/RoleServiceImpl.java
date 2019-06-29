package com.sc.crmsys.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.PermissionInformationBean;
import com.sc.crmsys.bean.PermissionRoleBean;
import com.sc.crmsys.bean.PermissionSubfieldBean;
import com.sc.crmsys.bean.RoleBean;
import com.sc.crmsys.mapper.PermissionInformationBeanMapper;
import com.sc.crmsys.mapper.PermissionRoleBeanMapper;
import com.sc.crmsys.mapper.PermissionSubfieldBeanMapper;
import com.sc.crmsys.mapper.RoleBeanMapper;

@Service("roleServiceImpl")
public class RoleServiceImpl implements RoleService{
	
	@Resource
	private PermissionSubfieldBeanMapper permissionSubfieldBeanMapper;
	
	@Resource
	private PermissionRoleBeanMapper permissionRoleBeanMapper;
	
	@Resource 
	private RoleBeanMapper roleBeanMapper;
	
	@Resource
	private PermissionInformationBeanMapper permissionInformationBeanMapper;

	@Override
	public List<PermissionInformationBean> selectAllPermission() {
		List<PermissionInformationBean> permissionList = permissionInformationBeanMapper.selectAllPermission();
		return permissionList;
	}

	@Override
	public void insertRole(RoleBean roleBean, String[] result) {
		roleBeanMapper.insertSelective(roleBean);
		for(int i = 0; i < result.length; i++)
		{
			PermissionRoleBean permissionRoleBean = new PermissionRoleBean();
			permissionRoleBean.setPermissionRoleNumber(UUID.randomUUID().toString());
			permissionRoleBean.setPermissionNumber(result[i]);
			permissionRoleBean.setRoleNumber(roleBean.getRoleNumber());
			permissionRoleBean.setPermissionRoleLastTime(new Date());
			permissionRoleBeanMapper.insertSelective(permissionRoleBean);
		}
		
	}

	@Override
	public PageInfo<RoleBean> selectAllRole(Integer pn, Integer size) {
		PageHelper.startPage(pn, size);
		List<RoleBean> roleList = roleBeanMapper.selectAllRole();
		PageInfo<RoleBean> pageInfo = new PageInfo<RoleBean>(roleList);
		return pageInfo;
	}

	@Override
	public RoleBean selectRoleById(String roleNumber) {
		RoleBean roleBean = roleBeanMapper.selectByPrimaryKey(roleNumber);
		return roleBean;
	}

	@Override
	public List<PermissionRoleBean> selectPMSRoleByRoleId(String roleNumber) {
		List<PermissionRoleBean> permissionRoleList = permissionRoleBeanMapper.selectPMSRoleByRoleId(roleNumber);
		return permissionRoleList;
	}

	@Override
	public void updateRole(RoleBean roleBean, String[] result) {
		permissionRoleBeanMapper.deleteByRoleNumer(roleBean.getRoleNumber());
		roleBeanMapper.updateByPrimaryKeySelective(roleBean);
		for(int i = 0; i < result.length; i++)
		{
			PermissionRoleBean permissionRoleBean = new PermissionRoleBean();
			permissionRoleBean.setPermissionRoleNumber(UUID.randomUUID().toString());
			permissionRoleBean.setPermissionNumber(result[i]);
			permissionRoleBean.setRoleNumber(roleBean.getRoleNumber());
			permissionRoleBean.setPermissionRoleLastTime(new Date());
			permissionRoleBeanMapper.insertSelective(permissionRoleBean);
		}
	}

	@Override
	public List<PermissionInformationBean> selectPermissionByUserId(String userId) {
		List<PermissionInformationBean> permissionList = permissionInformationBeanMapper.selectPermissionByUserId(userId);
		return permissionList;
	}

	@Override
	public List<PermissionSubfieldBean> selectSubfieldByUserId(String userId) {
		List<PermissionSubfieldBean> subfieldList = permissionSubfieldBeanMapper.selectSubfieldByUserId(userId);
		return subfieldList;
	}


}
