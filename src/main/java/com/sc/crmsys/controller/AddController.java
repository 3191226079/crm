package com.sc.crmsys.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.CustomerBean;
import com.sc.crmsys.bean.UserBean;
import com.sc.crmsys.service.Addservice;
import com.sc.crmsys.service.CustomerService;


@Controller
@RequestMapping("/add1")
public class AddController {
	
	@Resource
	private Addservice addservice;
	
	
	@Resource
	private CustomerService customerService;
	
	
	
	@RequestMapping("/add2")
	public String add(CustomerBean customer)
	{
	
		
		
		
		
		
		addservice.add(customer);
	
		 return "redirect:get";
		
	}
	
	
	@RequestMapping("/get")
	public String selectInfo1(@RequestParam(defaultValue="1")Integer pn,@RequestParam(defaultValue="5")Integer size,CustomerBean customerBean,Map<String, Object> map)
	{
		if(customerBean == null)
		{
			customerBean = new CustomerBean();
		}
		
		 PageInfo<CustomerBean> selectAll = customerService.selectAll(pn, size, customerBean);
		 map.put("selectAll", selectAll);
		 return "forward:/jsp/customer.jsp";
	}
	
	

	
	
	
	
	@RequestMapping("/get1")
	public String get1(String customerId,Map<String, Object> map)
	{
		CustomerBean get1 = customerService.get1(customerId);
		map.put("get1", get1);
		return "forward:/jsp/get1customer.jsp";
	}
	
	
	@RequestMapping("/update1")
	public String updatecu(CustomerBean customerBean)
	{
		
		customerService.update(customerBean);
		 return "redirect:get";
	}
	
	
	
	@RequestMapping("/del")
	public String delss(String customerId)
	{
		customerService.del(customerId);
		return "redirect:get";
	}
	@RequestMapping("/del1")
	public String delss1(String customerId)
	{
		customerService.del(customerId);
		return "redirect:/customerlose/selectlose";
	}

	

}
