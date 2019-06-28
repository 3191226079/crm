package com.sc.crmsys.mapper;

import java.util.List;

import com.sc.crmsys.bean.PermissionInformationBean;

public interface PermissionInformationBeanMapper {
    int deleteByPrimaryKey(String permissionNumber);

    int insert(PermissionInformationBean record);

    int insertSelective(PermissionInformationBean record);

    PermissionInformationBean selectByPrimaryKey(String permissionNumber);

    int updateByPrimaryKeySelective(PermissionInformationBean record);

    int updateByPrimaryKey(PermissionInformationBean record);
    
    List<PermissionInformationBean> selectAllPermission();
}