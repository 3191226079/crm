package com.sc.crmsys.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sc.crmsys.bean.DepartmentBean;
import com.sc.crmsys.bean.JobBean;
import com.sc.crmsys.mapper.DepartmentBeanMapper;
import com.sc.crmsys.mapper.JobBeanMapper;

@Service
public class JobServiceImpl implements JobService{

	@Resource
	private JobBeanMapper jobMapper;
	
	@Resource
	private DepartmentBeanMapper departmentMapper;
	
	@Override//查询职务与部门信息
	public List<DepartmentBean> selectJobAndDept() {
		List<DepartmentBean> selectDepAndJob = departmentMapper.selectDepAndJob();
		return selectDepAndJob;
	}

	@Override//查询部门与职务信息
	public List<JobBean> selectJobInfo() {
		List<JobBean> selectJobAndDept = jobMapper.selectJobAndDept();
		return selectJobAndDept;
	}

	@Override//添加职务
	public void addJob(JobBean jobBean) {
		jobMapper.insertSelective(jobBean);
	}

	@Override//删除职务
	public void deleteJob(String jobId) {
		jobMapper.deleteByPrimaryKey(jobId);
		
	}

}
