package com.sc.crmsys.controller;

import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sc.crmsys.bean.UserBean;

@RequestMapping("/user")
@Controller
public class UserController {
	
	@RequestMapping("/index")
	public String index()
	{
		return "jsp/main";
	}
	
	@RequestMapping("/head")
	public String head(Map<String, Object> map)
	{
		Subject subject = SecurityUtils.getSubject();
		UserBean userBean = (UserBean)subject.getPrincipal();
		map.put("username", userBean.getUserName());
		return "forward:/inc/head.jsp";
	}
}
