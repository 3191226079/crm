package com.sc.crmsys.mapper;

import org.apache.ibatis.annotations.Param;

import com.sc.crmsys.bean.UserRoleBean;

public interface UserRoleBeanMapper {
    int deleteByPrimaryKey(String userRoleId);

    int insert(UserRoleBean record);

    int insertSelective(UserRoleBean record);

    UserRoleBean selectByPrimaryKey(String userRoleId);

    int updateByPrimaryKeySelective(UserRoleBean record);

    int updateByPrimaryKey(UserRoleBean record);
    
    void updateUserRole(@Param("uid")String userId, @Param("rid")String roleNumber);
}