package com.sc.crmsys.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sc.crmsys.bean.TaskDetailBean;
import com.sc.crmsys.mapper.TaskDetailBeanMapper;

@Service("taskDetailService")
public class TaskDetailServiceImpl implements TaskDetailService{

	@Resource
	private TaskDetailBeanMapper taskDetailBeanMapper;
	

	@Override
	public TaskDetailBean selectByPrimaryKey(String taskDetailId) {
		TaskDetailBean taskDetailBean = taskDetailBeanMapper.selectByPrimaryKey(taskDetailId);
		return taskDetailBean;
	}

}
