package com.sc.crmsys.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sc.crmsys.bean.CustomerBean;
import com.sc.crmsys.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Resource
	private CustomerService customerService;
	
	@RequestMapping("/selectId")
	public String selectId(Map<String, Object> map)
	{
		
		List<CustomerBean> list = customerService.getcustomerIdInfo();
		map.put("list", list);
		return "forward:/jsp/outsaleout.jsp";
		
	}

}
