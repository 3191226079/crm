package com.sc.crmsys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

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
	
	@RequestMapping("/selectJobAndDept")
	@ResponseBody
	public HashMap<Object, Object> selectJobAndDept()
	{
		HashMap<Object, Object> hashMap = new HashMap<>();
		List<JobBean> selectJobAndDept = jobService.selectJobInfo();
		hashMap.put("jobAndDept", selectJobAndDept);
		return hashMap;
	}
	
	@RequestMapping("/selectAllInfo")
	public String selectAllInfo(Map map)
	{
		List<DepartmentBean> selectJobAndDept = jobService.selectJobAndDept();
		map.put("jobAndDept", selectJobAndDept);
		return "forward:/jsp/job_info.jsp";
	}
	
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
	
	@RequestMapping("/deleteJob")
	@ResponseBody
	public HashMap<Object, Object> deleteJob(String jobId)
	{
		jobService.deleteJob(jobId);
		HashMap<Object, Object> hashMap = new HashMap<>();
		hashMap.put("jobAndDept", "成功");
		return hashMap;
	}
	

}
