package com.sc.crmsys.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.TaskBean;
import com.sc.crmsys.bean.TaskDetailBean;
import com.sc.crmsys.mapper.TaskBeanMapper;
import com.sc.crmsys.mapper.TaskDetailBeanMapper;

@Service("/taskService")
public class TaskServiceImpl implements TaskService{

	@Resource
	private TaskBeanMapper taskBeanMapper;
	
	@Resource
	private TaskDetailBeanMapper taskDetailBeanMapper;
	
	@Override
	public void insert(TaskBean taskBean, TaskDetailBean taskDetailBean) {
		taskBeanMapper.insert(taskBean);
		taskDetailBeanMapper.insert(taskDetailBean);
	}

	@Override
	public PageInfo<TaskDetailBean> selectAll(Integer pn, Integer size, TaskBean taskBean) {
		PageHelper.startPage(pn,size);
		List<TaskDetailBean> TaskDetailBean = taskDetailBeanMapper.selectAll(taskBean);
		PageInfo<TaskDetailBean> pageInfo = new PageInfo<TaskDetailBean>(TaskDetailBean);
		return pageInfo;
	}

	@Override
	public void deleteByPrimaryKey(String taskId) {
		taskBeanMapper.deleteByPrimaryKey(taskId);
	}


	@Override
	public void updateByPrimaryKeySelective(TaskBean taskBean, TaskDetailBean taskDetailBean) {
		taskBeanMapper.updateByPrimaryKeySelective(taskBean);
		taskDetailBeanMapper.updateByPrimaryKeySelective(taskDetailBean);
	}

	@Override
	public TaskBean selectByPrimaryKey(String taskId) {
		TaskBean taskBean = taskBeanMapper.selectByPrimaryKey(taskId);
		return taskBean;
	}

	@Override
	public PageInfo<TaskDetailBean> selectAllTask(Integer pn, Integer size, TaskBean taskBean) {
		PageHelper.startPage(pn, size);
		List<TaskDetailBean> selectAllTaskList = taskDetailBeanMapper.selectAllTask(taskBean);
		PageInfo<TaskDetailBean> pageInfo = new PageInfo<TaskDetailBean>(selectAllTaskList);
		return pageInfo;
	}

	
}
