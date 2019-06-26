package com.sc.crmsys.mapper;

import org.apache.ibatis.annotations.Param;

import com.sc.crmsys.bean.SignCountBean;

public interface SignCountBeanMapper {
    int deleteByPrimaryKey(String signCountId);

    int insert(SignCountBean record);

    int insertSelective(SignCountBean record);

    SignCountBean selectByPrimaryKey(String signCountId);

    int updateByPrimaryKeySelective(SignCountBean record);

    int updateByPrimaryKey(SignCountBean record);
    
    SignCountBean getConutInfo(@Param("userId")String userId,@Param("year")String year,@Param("month")String month);
    
    SignCountBean getYesCount(SignCountBean signCount);
    
    String signCount(@Param("userId")String userId,@Param("year")String year,@Param("month")String month);

}