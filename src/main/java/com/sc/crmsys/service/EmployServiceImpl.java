package com.sc.crmsys.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.EmployBean;
import com.sc.crmsys.bean.JobBean;
import com.sc.crmsys.mapper.DepartmentBeanMapper;
import com.sc.crmsys.mapper.EmployBeanMapper;
import com.sc.crmsys.mapper.JobBeanMapper;
import com.sc.crmsys.mapper.JournalBeanMapper;

@Service("employServiceImpl")
public class EmployServiceImpl implements EmployService{

	@Resource
	private EmployBeanMapper employBeanMapper;
	
	@Resource
	private JobBeanMapper jobBeanMapper;
	
	@Override
	public List<EmployBean> selectAllEmploy() {
		List<EmployBean> employList = employBeanMapper.selectAllEmploy();
		return employList;
	}
	@Override
	public PageInfo<EmployBean> eamployInfo(int pn,int size,String content) {
		PageHelper.startPage(pn, size);
		List<EmployBean> employInfo = employBeanMapper.employInfo(content);
		PageInfo<EmployBean> pageInfo = new PageInfo<>(employInfo);
		return pageInfo;
	}
	
	@Override
	public String selectJobId(String jobName) {
		String jobId = jobBeanMapper.selectJobId(jobName);
		return jobId;
	}
	@Override
	public void updateJob(EmployBean record) {
		employBeanMapper.updateByPrimaryKeySelective(record);
	}
	

}
