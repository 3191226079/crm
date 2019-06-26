package com.sc.crmsys.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.EmployBean;
import com.sc.crmsys.bean.UserBean;
import com.sc.crmsys.service.EmployService;
import com.sc.crmsys.service.SignService;

@Controller
@RequestMapping("/mangePerson")
public class MangePersonController {
	
	@Resource
	private EmployService employ;
	@Resource
	private SignService signService;
	
	
	@RequestMapping("/info")
	public String getEmployInfo(Map<Object,Object> map,@RequestParam(defaultValue="1")Integer pn,@RequestParam(defaultValue="5")Integer size,String content)
	{
		PageInfo<EmployBean> eamployInfo = employ.employInfo(pn,size,content);
		map.put("employ", eamployInfo);
		return "forward:/jsp/mange_person.jsp";
	}
	
	@RequestMapping("/updateJob")
	@ResponseBody
	public HashMap<String, Object> UpdateJob(String jobName,EmployBean employBean)
	{
		String jobId = employ.selectJobId(jobName);
		employBean.setJobId(jobId);
		employ.updateJob(employBean);
		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		hashMap.put("result", "操作成功");
		return hashMap;
	}
	
	
	@RequestMapping("/salary")
	public String getSalaryInfo(Map<Object,Object> map,@RequestParam(defaultValue="1")Integer pn,@RequestParam(defaultValue="5")Integer size,String content)
	{
		PageInfo<EmployBean> eamployInfo = employ.employInfo(pn,size,content);
		map.put("employ", eamployInfo);
		return "forward:/jsp/salary.jsp";
	}
	
}
