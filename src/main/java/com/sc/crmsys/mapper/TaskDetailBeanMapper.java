package com.sc.crmsys.mapper;

import com.sc.crmsys.bean.TaskDetailBean;

public interface TaskDetailBeanMapper {
    int deleteByPrimaryKey(String taskDetailId);

    int insert(TaskDetailBean record);

    int insertSelective(TaskDetailBean record);

    TaskDetailBean selectByPrimaryKey(String taskDetailId);

    int updateByPrimaryKeySelective(TaskDetailBean record);

    int updateByPrimaryKey(TaskDetailBean record);
}