package com.sc.crmsys.mapper;

import com.sc.crmsys.bean.InfoDetailBean;

public interface InfoDetailBeanMapper {
    int deleteByPrimaryKey(String infoDetailId);

    int insert(InfoDetailBean record);

    int insertSelective(InfoDetailBean record);

    InfoDetailBean selectByPrimaryKey(String infoDetailId);

    int updateByPrimaryKeySelective(InfoDetailBean record);

    int updateByPrimaryKey(InfoDetailBean record);
}