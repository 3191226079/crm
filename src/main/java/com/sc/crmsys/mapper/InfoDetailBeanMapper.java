package com.sc.crmsys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sc.crmsys.bean.InfoDetailBean;

public interface InfoDetailBeanMapper {
    void deleteByinfoDetailId(String infoDetailId);

    int insert(InfoDetailBean infoDetailBean);

    int insertSelective(InfoDetailBean record);

    InfoDetailBean selectByPrimaryKey(String infoDetailId);

    int updateByPrimaryKeySelective(InfoDetailBean record);

    void updateByPrimaryKey(@Param("i")String infoDetailId);
    
    List<InfoDetailBean> selectAll(@Param("i")InfoDetailBean infoDetailBean);
    
    void update(@Param("e")String employId);
}