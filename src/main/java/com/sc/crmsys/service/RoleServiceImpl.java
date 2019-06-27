package com.sc.crmsys.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sc.crmsys.bean.PermissionInformationBean;
import com.sc.crmsys.mapper.PermissionInformationBeanMapper;

@Service("roleServiceImpl")
public class RoleServiceImpl implements RoleService{
	
	@Resource
	private PermissionInformationBeanMapper permissionInformationBeanMapper;

	@Override
	public List<PermissionInformationBean> selectAllPermission() {
		List<PermissionInformationBean> permissionList = permissionInformationBeanMapper.selectAllPermission();
		return permissionList;
	}

}
