package com.sc.crmsys.mapper;

import com.sc.crmsys.bean.CityBean;

public interface CityBeanMapper {
    int deleteByPrimaryKey(String cityNumber);

    int insert(CityBean record);

    int insertSelective(CityBean record);

    CityBean selectByPrimaryKey(String cityNumber);

    int updateByPrimaryKeySelective(CityBean record);

    int updateByPrimaryKey(CityBean record);
}