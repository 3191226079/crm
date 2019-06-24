package com.sc.crmsys.controller;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sc.crmsys.bean.UserBean;
import com.sc.crmsys.service.UserService;
import com.sc.crmsys.utils.MyUtils;

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
	
	@RequestMapping("/jumptoupdatepass")
	public String jumpToUpdatePass(Map<String, Object> map, String fail)
	{
		Subject subject = SecurityUtils.getSubject();
		UserBean userBean = (UserBean)subject.getPrincipal();
		map.put("userBean", userBean);
		map.put("fail", fail);
		return "jsp/updatepwd";
	}
	
	@RequestMapping("/updatepass")
	public String updatePass(Map<String, Object> map, String oldPass, String newPass)
	{
		Subject subject = SecurityUtils.getSubject();
		UserBean userBean = (UserBean)subject.getPrincipal();
		if(userBean.getUserPassword().equals(MyUtils.md5(oldPass, userBean.getUserSalt(), 1)))
		{
			String salt = MyUtils.getSalt();
			Date date = new Date();
			String md5 = MyUtils.md5(newPass, salt, 1);
			userBean.setUserPassword(md5);
			userBean.setUserSalt(salt);
			userBean.setUserUpdateTime(date);
			userServiceImpl.updateByPrimaryKeySelective(userBean);
			return "jsp/exit";
		}
		else
		{
			map.put("fail", "* 输入密码错误");
		}
		return "redirect:/user/jumptoupdatepass";
	}
}
