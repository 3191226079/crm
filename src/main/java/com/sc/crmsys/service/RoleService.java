package com.sc.crmsys.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.PermissionInformationBean;
import com.sc.crmsys.bean.PermissionRoleBean;
import com.sc.crmsys.bean.PermissionSubfieldBean;
import com.sc.crmsys.bean.RoleBean;

public interface RoleService {
	public List<PermissionInformationBean> selectAllPermission();
	public void insertRole(RoleBean roleBean, String result[]);
	public PageInfo<RoleBean> selectAllRole(Integer pn, Integer size);
	public RoleBean selectRoleById(String roleNumber);
	public List<PermissionRoleBean> selectPMSRoleByRoleId(String roleNumber);
	public void updateRole(RoleBean roleBean, String result[]);
	
	public List<PermissionInformationBean> selectPermissionByUserId(String userId);
	
	List<PermissionSubfieldBean> selectSubfieldByUserId(String userId);
}
