package com.sc.crmsys.mapper;

import com.sc.crmsys.bean.SystemBean;

public interface SystemBeanMapper {
    int deleteByPrimaryKey(String systemId);

    int insert(SystemBean record);

    int insertSelective(SystemBean record);

    SystemBean selectByPrimaryKey(String systemId);

    int updateByPrimaryKeySelective(SystemBean record);

    int updateByPrimaryKey(SystemBean record);
}