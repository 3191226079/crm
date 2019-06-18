package com.sc.crmsys.mapper;

import com.sc.crmsys.bean.ActiveBean;

public interface ActiveBeanMapper {
    int deleteByPrimaryKey(String activeId);

    int insert(ActiveBean record);

    int insertSelective(ActiveBean record);

    ActiveBean selectByPrimaryKey(String activeId);

    int updateByPrimaryKeySelective(ActiveBean record);

    int updateByPrimaryKey(ActiveBean record);
}