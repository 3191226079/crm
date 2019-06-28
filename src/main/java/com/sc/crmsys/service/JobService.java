package com.sc.crmsys.service;

import java.util.List;

import com.sc.crmsys.bean.DepartmentBean;
import com.sc.crmsys.bean.JobBean;

public interface JobService {
	
	List<DepartmentBean> selectJobAndDept();
	
	List<JobBean> selectJobInfo();
	
	void addJob(JobBean jobBean);
	
	void deleteJob(String jobId);

}
