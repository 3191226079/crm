package com.sc.crmsys.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sc.crmsys.bean.CustomerBean;
import com.sc.crmsys.service.Addservice;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

@Controller
@RequestMapping("/add")
public class AddController {
	
	@Resource
	private Addservice addservice;
	
	@RequestMapping("/add1")
	public String add(CustomerBean customer)
	{
		System.out.println(customer);
		addservice.add(customer);
		return "forward:/jsp/add.jsp";
		
	}

	

}
