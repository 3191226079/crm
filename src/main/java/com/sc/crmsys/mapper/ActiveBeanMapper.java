package com.sc.crmsys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sc.crmsys.bean.ActiveBean;

public interface ActiveBeanMapper {
    void deleteByPrimaryKey(String activeId);

    void insert(ActiveBean active);

    int insertSelective(ActiveBean record);

    List<ActiveBean> selectAll(@Param("t")String activeTitle);

    void updateByPrimaryKeySelective(ActiveBean activeBean);

    int updateByPrimaryKey(ActiveBean record);
    
    List<ActiveBean> selectByTitle(@Param("title")String activeTilte);
    
    ActiveBean selectByPrimaryKey(String activeId);
}