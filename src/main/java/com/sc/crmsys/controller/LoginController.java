package com.sc.crmsys.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String login(Map<String, Object> map,HttpServletRequest req)
	{
		String shiroLoginFailure = (String)req.getAttribute("shiroLoginFailure");
		String fail = "";
		if(shiroLoginFailure != null)
		{
			if(shiroLoginFailure.equals(UnknownAccountException.class.getName()))
			{
				fail = "用户名不存在";
			}
			else if(shiroLoginFailure.equals(IncorrectCredentialsException.class.getName()))
			{
				fail = "用户名或密码错误";
			}
		}
		map.put("fail", fail);
		return "redirect:/login.jsp";
	}
}
