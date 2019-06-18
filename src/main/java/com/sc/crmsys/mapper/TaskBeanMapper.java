package com.sc.crmsys.mapper;

import com.sc.crmsys.bean.TaskBean;

public interface TaskBeanMapper {
    int deleteByPrimaryKey(String taskId);

    int insert(TaskBean record);

    int insertSelective(TaskBean record);

    TaskBean selectByPrimaryKey(String taskId);

    int updateByPrimaryKeySelective(TaskBean record);

    int updateByPrimaryKey(TaskBean record);
}