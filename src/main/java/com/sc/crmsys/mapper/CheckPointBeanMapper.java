package com.sc.crmsys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sc.crmsys.bean.CheckPointBean;

public interface CheckPointBeanMapper {
    void deleteByPrimaryKey(String checkPointId);

    void insert(CheckPointBean record);

    int insertSelective(CheckPointBean record);

    CheckPointBean selectByPrimaryKey(String checkPointId);

    void updateByPrimaryKeySelective(CheckPointBean checkPointBean);

    int updateByPrimaryKey(CheckPointBean record);
    
    List<CheckPointBean> selectAll(@Param("c")String checkPointTarget);
}