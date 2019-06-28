package com.sc.crmsys.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sc.crmsys.bean.CustomerBean;
import com.sc.crmsys.service.Addservice;


@Controller
@RequestMapping("/add")
public class AddController {
	
	@Resource
	private Addservice addservice;
	
	@RequestMapping("/add1")
	public String add(CustomerBean customer)
	{
	
		addservice.add(customer);
		return "forward:/jsp/add.jsp";
		
	}

	

}
