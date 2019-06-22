package com.sc.crmsys.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sc.crmsys.bean.UserBean;
import com.sc.crmsys.service.UserService;

@RequestMapping("/user")
@Controller
public class UserController {
	
	@Resource
	private UserService userServiceImpl;
	
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
	
	@RequestMapping("/logout")
	public String logout()
	{
		return "redirect:/logout.do";
	}
	
	@RequestMapping("/updatepass")
	public String updatePass(Map<String, Object> map)
	{
		Subject subject = SecurityUtils.getSubject();
		UserBean userBean = (UserBean)subject.getPrincipal();
		map.put("userBean", userBean);
		return "jsp/updatepwd";
	}
}
