package com.sc.crmsys.service;

import java.util.List;

import com.sc.crmsys.bean.PermissionInformationBean;

public interface RoleService {
	public List<PermissionInformationBean> selectAllPermission();
}
