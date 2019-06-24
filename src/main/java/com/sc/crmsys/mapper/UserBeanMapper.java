package com.sc.crmsys.mapper;

import org.apache.ibatis.annotations.Param;

import com.sc.crmsys.bean.UserBean;

public interface UserBeanMapper {
    int deleteByPrimaryKey(String userId);

    int insert(UserBean record);

    int insertSelective(UserBean record);

    UserBean selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(UserBean record);

    int updateByPrimaryKey(UserBean record);
    
    UserBean selectByUserName(@Param("uname")String userName);
    
}