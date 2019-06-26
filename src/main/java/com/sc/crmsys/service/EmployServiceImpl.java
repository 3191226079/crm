package com.sc.crmsys.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.EmployBean;
import com.sc.crmsys.bean.JobBean;
import com.sc.crmsys.bean.UserBean;
import com.sc.crmsys.mapper.DepartmentBeanMapper;
import com.sc.crmsys.mapper.EmployBeanMapper;
import com.sc.crmsys.mapper.JobBeanMapper;
import com.sc.crmsys.mapper.JournalBeanMapper;

@Service("employServiceImpl")
public class EmployServiceImpl implements EmployService{

	@Resource
	private EmployBeanMapper employBeanMapper;
	
	@Resource
	private SignService signService;
	
	@Resource
	private JobBeanMapper jobBeanMapper;
	
	@Override
	public List<EmployBean> selectAllEmploy() {
		List<EmployBean> employList = employBeanMapper.selectAllEmploy();
		return employList;
	}
	@SuppressWarnings("deprecation")
	@Override
	public PageInfo<EmployBean> employInfo(int pn,int size,String content) {
		PageHelper.startPage(pn, size);
		List<EmployBean> employInfo = employBeanMapper.employInfo(content);
		for (int i = 0; i < employInfo.size(); i++) {
			EmployBean employBean = employInfo.get(i);
			UserBean userBean = employBean.getUserBean();
			Date date = new Date(); 
			int year = date.getYear(); 
		    int month = date.getMonth()+1; 
		    
		    Integer signCount = signService.signNum(userBean.getUserId(),String.valueOf(year),String.valueOf(month));
			int days = new Date(year,month,0).getDate();
			int littleCount = days-signCount.intValue();
			employBean.setLittleCount(littleCount);
			employBean.setSignCount(signCount);
		}
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
