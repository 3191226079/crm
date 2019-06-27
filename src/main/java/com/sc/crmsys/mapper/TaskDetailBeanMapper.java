package com.sc.crmsys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sc.crmsys.bean.TaskBean;
import com.sc.crmsys.bean.TaskDetailBean;

public interface TaskDetailBeanMapper {
    void deleteByPrimaryKey(String taskDetailId);

    int insert(TaskDetailBean record);

    int insertSelective(TaskDetailBean record);

    TaskDetailBean selectByPrimaryKey(String taskDetailId);

    void updateByPrimaryKeySelective(TaskDetailBean record);

    int updateByPrimaryKey(TaskDetailBean record);
    
    List<TaskDetailBean> selectAll(@Param("t")TaskBean taskBean);
    
    List<TaskDetailBean> selectAllTask(@Param("t")TaskBean taskBean);
}