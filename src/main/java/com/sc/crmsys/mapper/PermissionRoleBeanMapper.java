package com.sc.crmsys.mapper;

import com.sc.crmsys.bean.PermissionRoleBean;

public interface PermissionRoleBeanMapper {
    int deleteByPrimaryKey(String permissionRoleNumber);

    int insert(PermissionRoleBean record);

    int insertSelective(PermissionRoleBean record);

    PermissionRoleBean selectByPrimaryKey(String permissionRoleNumber);

    int updateByPrimaryKeySelective(PermissionRoleBean record);

    int updateByPrimaryKey(PermissionRoleBean record);
}