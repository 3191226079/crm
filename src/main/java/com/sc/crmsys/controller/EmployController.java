package com.sc.crmsys.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sc.crmsys.bean.EmployBean;
import com.sc.crmsys.bean.InfoBean;
import com.sc.crmsys.bean.UserBean;
import com.sc.crmsys.service.EmployService;

@Controller
@RequestMapping("/employ")
public class EmployController {

	@Resource
	private EmployService employServiceImpl;
	
	@RequestMapping("/selectEmploy")
	public String selectInfo(Map<String, Object> map,InfoBean infoBean,EmployBean employBean)
	{
		Subject subject = SecurityUtils.getSubject();
		UserBean userBean = (UserBean)subject.getPrincipal();
		employBean.setEmployId(userBean.getEmployId());
		employServiceImpl.update(employBean.getEmployId());
		EmployBean selectInfo = employServiceImpl.selectInfo(infoBean,employBean.getEmployId());
		map.put("selectInfo", selectInfo);
		return "forward:/jsp/employLook.jsp";
	}
	
	@RequestMapping("/delete")
	public String delete(String employId)
	{
		employServiceImpl.deleteByPrimaryKey(employId);
		return "redirect:selectEmploy";
	}
}
