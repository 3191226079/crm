package com.sc.crmsys.mapper;

import com.sc.crmsys.bean.RoleBean;

public interface RoleBeanMapper {
    int deleteByPrimaryKey(String roleNumber);

    int insert(RoleBean record);

    int insertSelective(RoleBean record);

    RoleBean selectByPrimaryKey(String roleNumber);

    int updateByPrimaryKeySelective(RoleBean record);

    int updateByPrimaryKey(RoleBean record);
}