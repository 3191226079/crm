package com.sc.crmsys.service;

import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.TaskBean;
import com.sc.crmsys.bean.TaskDetailBean;

public interface TaskService {

	public void insert(TaskBean taskBean,TaskDetailBean taskDetailBean);
	
	public PageInfo<TaskDetailBean> selectAll(Integer pn,Integer size,TaskBean taskBean);
	
	public void deleteByPrimaryKey(String taskId);
	
	public TaskBean selectByPrimaryKey(String taskId);
	
	public void updateByPrimaryKeySelective(TaskBean taskBean,TaskDetailBean taskDetailBean);
	
	public PageInfo<TaskDetailBean> selectAllTask(Integer pn,Integer size,TaskBean taskBean);
}
