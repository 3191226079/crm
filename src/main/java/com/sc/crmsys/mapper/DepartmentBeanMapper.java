package com.sc.crmsys.mapper;

import com.sc.crmsys.bean.DepartmentBean;

public interface DepartmentBeanMapper {
    int deleteByPrimaryKey(String deptNumber);

    int insert(DepartmentBean record);

    int insertSelective(DepartmentBean record);

    DepartmentBean selectByPrimaryKey(String deptNumber);

    int updateByPrimaryKeySelective(DepartmentBean record);

    int updateByPrimaryKey(DepartmentBean record);
}