package com.sc.crmsys.mapper;

import com.sc.crmsys.bean.InfoBean;

public interface InfoBeanMapper {
    void deleteByinfoId(String infoId);

    int insert(InfoBean infoBean);

    int insertSelective(InfoBean record);

    InfoBean selectByPrimaryKey(String infoId);

    int updateByPrimaryKeySelective(InfoBean record);

    int updateByPrimaryKey(InfoBean record);
    
}