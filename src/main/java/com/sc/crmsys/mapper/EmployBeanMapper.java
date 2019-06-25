package com.sc.crmsys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sc.crmsys.bean.EmployBean;

public interface EmployBeanMapper {
    int deleteByPrimaryKey(String employId);

    int insert(EmployBean record);

    int insertSelective(EmployBean record);

    EmployBean selectByPrimaryKey(String employId);

    int updateByPrimaryKeySelective(EmployBean record);

    int updateByPrimaryKey(EmployBean record);
    
    List<EmployBean> selectAllEmploy();
    
    List<EmployBean> employInfo(@Param("content")String content);
    
}