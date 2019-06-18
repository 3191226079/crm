package com.sc.crmsys.mapper;

import com.sc.crmsys.bean.UserRoleBean;

public interface UserRoleBeanMapper {
    int deleteByPrimaryKey(String userRoleId);

    int insert(UserRoleBean record);

    int insertSelective(UserRoleBean record);

    UserRoleBean selectByPrimaryKey(String userRoleId);

    int updateByPrimaryKeySelective(UserRoleBean record);

    int updateByPrimaryKey(UserRoleBean record);
}