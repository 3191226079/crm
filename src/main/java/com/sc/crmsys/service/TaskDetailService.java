package com.sc.crmsys.service;

import com.sc.crmsys.bean.TaskDetailBean;

public interface TaskDetailService {

	public void deleteByPrimaryKey(String taskDetailId);
	
	public TaskDetailBean selectByPrimaryKey(String taskDetailId);
	
}
