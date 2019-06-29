package com.sc.crmsys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sc.crmsys.bean.PermissionRoleBean;

public interface PermissionRoleBeanMapper {
    int deleteByPrimaryKey(String permissionRoleNumber);

    int insert(PermissionRoleBean record);

    int insertSelective(PermissionRoleBean record);

    PermissionRoleBean selectByPrimaryKey(String permissionRoleNumber);

    int updateByPrimaryKeySelective(PermissionRoleBean record);

    int updateByPrimaryKey(PermissionRoleBean record);
    
    List<PermissionRoleBean> selectPMSRoleByRoleId(@Param("rnum")String roleNumber);
    
    void deleteByRoleNumer(@Param("rnum")String roleNumber);
}