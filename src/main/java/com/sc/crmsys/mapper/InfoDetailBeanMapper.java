package com.sc.crmsys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sc.crmsys.bean.InfoDetailBean;

public interface InfoDetailBeanMapper {
    int deleteByPrimaryKey(String infoDetailId);

    int insert(InfoDetailBean infoDetailBean);

    int insertSelective(InfoDetailBean record);

    InfoDetailBean selectByPrimaryKey(String infoDetailId);

    int updateByPrimaryKeySelective(InfoDetailBean record);

    int updateByPrimaryKey(InfoDetailBean record);
    
    List<InfoDetailBean> selectAll(@Param("i")InfoDetailBean infoDetailBean);
}