package com.sc.crmsys.mapper;

import com.sc.crmsys.bean.TaskBean;

public interface TaskBeanMapper {
    void deleteByPrimaryKey(String taskId);

    int insert(TaskBean record);

    int insertSelective(TaskBean record);

    TaskBean selectByPrimaryKey(String taskId);

    void updateByPrimaryKeySelective(TaskBean record);

    int updateByPrimaryKey(TaskBean record);
}