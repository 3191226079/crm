package com.sc.crmsys.mapper;

import com.sc.crmsys.bean.InfoBean;

public interface InfoBeanMapper {
    int deleteByPrimaryKey(String infoId);

    int insert(InfoBean record);

    int insertSelective(InfoBean record);

    InfoBean selectByPrimaryKey(String infoId);

    int updateByPrimaryKeySelective(InfoBean record);

    int updateByPrimaryKey(InfoBean record);
}