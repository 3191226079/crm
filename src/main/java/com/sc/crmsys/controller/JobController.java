package com.sc.crmsys.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.crmsys.bean.DepartmentBean;
import com.sc.crmsys.bean.JobBean;
import com.sc.crmsys.service.JobService;

@Controller
@RequestMapping("/job")
public class JobController {
	
	@Resource
	private JobService jobService;

	@RequiresPermissions("huguan:change")
	@RequestMapping("/selectJobAndDept")
	@ResponseBody
	public List<DepartmentBean> selectJobAndDept()
	{
		List<DepartmentBean> selectJobAndDept = jobService.selectJobAndDept();
		return selectJobAndDept;
	}
	
	@RequiresPermissions("huguan:change")
	@RequestMapping("/selectAllInfo")
	public String selectAllInfo(Map map)
	{
		List<DepartmentBean> selectJobAndDept = jobService.selectJobAndDept();
		map.put("jobAndDept", selectJobAndDept);
		return "forward:/jsp/job_info.jsp";
	}
	
	@RequiresPermissions("huguan:change")
	@RequestMapping("/addJob")
	@ResponseBody
	public HashMap<Object, Object> addJob(JobBean jobBean)
	{
		String jobId = UUID.randomUUID().toString();
		jobBean.setJobId(jobId);
		jobService.addJob(jobBean);
		HashMap<Object, Object> hashMap = new HashMap<>();
		hashMap.put("jobAndDept", "成功");
		return hashMap;
	}
	
	@RequiresPermissions("huguan:change")
	@RequestMapping("/deleteJob")
	@ResponseBody
	public HashMap<Object, Object> deleteJob(String jobId)
	{
		jobService.deleteJob(jobId);
		HashMap<Object, Object> hashMap = new HashMap<>();
		hashMap.put("jobAndDept", "成功");
		return hashMap;
	}
	
	@RequiresPermissions("huguan:change")
	@RequestMapping("/addDepartment")
	@ResponseBody
	public HashMap<Object, Object> addDepartment(JobBean jobBean,DepartmentBean deptBean)
	{
		HashMap<Object, Object> hashMap = new HashMap<>();
		String deptNumber= UUID.randomUUID().toString();
		String jobId = UUID.randomUUID().toString();
		jobBean.setJobId(jobId);
		jobBean.setDeptNumber(deptNumber);
		jobService.addJob(jobBean);
		deptBean.setDeptNumber(deptNumber);
		jobService.addDepartment(deptBean);
		hashMap.put("depart", "成功");
		return hashMap;
	}
	
	@RequiresPermissions("huguan:change")
	@RequestMapping("/del_dept")
	@ResponseBody
	public HashMap<Object, Object> delDept(String deptNumber)
	{
		HashMap<Object, Object> hashMap = new HashMap<>();
		jobService.delDept(deptNumber);
		hashMap.put("del", "成功");
		return hashMap;
	}
	
	@RequiresPermissions("huguan:change")
	@RequestMapping("/updateJob")
	@ResponseBody
	public HashMap<Object, Object> updateJob(JobBean jobBean,DepartmentBean deptBean)
	{
		HashMap<Object, Object> hashMap = new HashMap<>();
		jobBean.setJobLastTime(new Date());
		jobService.update(jobBean,deptBean);
		hashMap.put("del", "成功");
		return hashMap;
	}
}
