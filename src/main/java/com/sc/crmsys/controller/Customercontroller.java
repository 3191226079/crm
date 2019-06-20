package com.sc.crmsys.controller;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sc.crmsys.bean.CustomerBean;
import com.sc.crmsys.service.ContactService;

@Controller
@RequestMapping("/customer")
public class Customercontroller {
	
	@Resource
	private ContactService contactService;
	
	@RequestMapping("/info")
	public String CustomerInfo(CustomerBean customer)
	{
		String customerId = UUID.randomUUID().toString();
		customer.setCustomerId(customerId);
		contactService.addCustomerInfo(customer);
		return "添加成功";
		
	}
	

}
