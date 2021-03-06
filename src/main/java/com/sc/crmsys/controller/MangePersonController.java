package com.sc.crmsys.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.EmployBean;
import com.sc.crmsys.bean.JobBean;
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
	
	@RequiresPermissions("huguan:person")
	@RequestMapping("/info")
	public String getEmployInfo(Map<Object,Object> map,@RequestParam(defaultValue="1")Integer pn,@RequestParam(defaultValue="5")Integer size,String content)
	{
		PageInfo<EmployBean> eamployInfo = employ.employInfo(pn,size,content);
		map.put("employ", eamployInfo);
		return "forward:/jsp/mange_person.jsp";
	}
	
	@RequiresPermissions("huguan:person")
	@RequestMapping("/updateJob")
	@ResponseBody
	public HashMap<String, Object> UpdateJob(JobBean jobBean,EmployBean employBean)
	{
		employBean.setJobId(jobBean.getJobId());
		employ.updateJob(employBean);
		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		hashMap.put("result", "操作成功");
		return hashMap;
	}
	
	@RequiresPermissions("huguan:person")
	@RequestMapping("/salary")
	public String getSalaryInfo(Map<Object,Object> map,@RequestParam(defaultValue="1")Integer pn,@RequestParam(defaultValue="5")Integer size,String content)
	{
		PageInfo<EmployBean> eamployInfo = employ.employInfo(pn,size,content);
		map.put("employ", eamployInfo);
		return "forward:/jsp/salary.jsp";
	}
	
}
