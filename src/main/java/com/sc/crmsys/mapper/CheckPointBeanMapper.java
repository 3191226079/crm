package com.sc.crmsys.mapper;

import com.sc.crmsys.bean.CheckPointBean;

public interface CheckPointBeanMapper {
    int deleteByPrimaryKey(String checkPointId);

    int insert(CheckPointBean record);

    int insertSelective(CheckPointBean record);

    CheckPointBean selectByPrimaryKey(String checkPointId);

    int updateByPrimaryKeySelective(CheckPointBean record);

    int updateByPrimaryKey(CheckPointBean record);
}