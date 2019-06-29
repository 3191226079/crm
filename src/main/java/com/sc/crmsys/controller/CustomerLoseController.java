package com.sc.crmsys.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RequestParam;


import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.CustomerLoseBean;
import com.sc.crmsys.service.CustomerLoseService;

@Controller
@RequestMapping("/customerlose")
public class CustomerLoseController {
	
	@Resource
	private CustomerLoseService customerLoseService;
	
	
	@RequiresPermissions("kunda:customermanage")
	@RequestMapping("/select")
	public String select(String customerLoseId,Map<String, Object> map)
	{
			
		
		CustomerLoseBean selectcustomerlose = customerLoseService.selectcustomerlose(customerLoseId);
		map.put("selectcustomerlose", selectcustomerlose);
		
		return "forward:/jsp/selectcustomerlose.jsp";
	}
	
	@RequiresPermissions("kunda:customermanage")
	@RequestMapping("/select1")
	public String select1(String customerLoseId,Map<String, Object> map)
	{
			
		
		CustomerLoseBean selectcustomerlose = customerLoseService.selectcustomerlose(customerLoseId);
		map.put("selectcustomerlose", selectcustomerlose);
		
		return "forward:/jsp/selectcustomerlose1.jsp";
	}
	
	@RequiresPermissions("kunda:customermanage")
	@RequestMapping("/update")
	public String update(CustomerLoseBean customer)
	{
		 customerLoseService.updatecustomerlose(customer);
		return "redirect:getcustomerlose";
	}
	
	@RequiresPermissions("kunda:customermanage")
	@RequestMapping("/update1")
	public String update1(CustomerLoseBean customer)
	{
		 customerLoseService.updatecustomerlose(customer);
		return "redirect:getconfirmationofloss";
	}
	
	@RequiresPermissions("kunda:customermanage")
	@RequestMapping("/getconfirmationofloss")
	public String selectInfo1(@RequestParam(defaultValue="1")Integer pn,@RequestParam(defaultValue="5")Integer size,CustomerLoseBean customerLoseBean,Map<String, Object> map)
	{
		if(customerLoseBean == null)
		{
			customerLoseBean = new CustomerLoseBean();
		}
		
		 PageInfo<CustomerLoseBean> selectAll = customerLoseService.selectAll1(pn, size, customerLoseBean);
		 map.put("selectAll", selectAll);
		 return "forward:/jsp/confirmationofloss.jsp";
	}
	

	@RequestMapping("getselectcostom")
	@ResponseBody
	//把结果转换成json
	public Map<String, Object> getAll(Map<String, Object> map)
	{
		List<CustomerLoseBean> selectCustomerlose = customerLoseService.getSelectCustomerlose();
		map.put("selectCustomerlose", selectCustomerlose);
		return map;
		
	}

	
	@RequiresPermissions("kunda:customermanage")
	@RequestMapping("/del")
	public String del(String customerLoseId)
	{
		customerLoseService.del(customerLoseId);
		return "redirect:getconfirmationofloss";
	}
	
	@RequiresPermissions("kunda:customermanage")
	@RequestMapping("/getcustomerlose")
	public String selectInfo(@RequestParam(defaultValue="1")Integer pn,@RequestParam(defaultValue="5")Integer size,CustomerLoseBean customerLoseBean,Map<String, Object> map)
	{
		if(customerLoseBean == null)
		{
			customerLoseBean = new CustomerLoseBean();
		}
		
		 PageInfo<CustomerLoseBean> selectAll = customerLoseService.selectAll(pn, size, customerLoseBean);
		 map.put("selectAll", selectAll);
		 return "forward:/jsp/customerlose.jsp";
	}
	
	@RequiresPermissions("kunda:customermanage")
	@RequestMapping("/selectlose")
	public String selectlose(@RequestParam(defaultValue="1")Integer pn,@RequestParam(defaultValue="5")Integer size,CustomerLoseBean customerLoseBean,Map<String, Object> map)
	{
		
	
		  PageInfo<CustomerLoseBean> selectAll = customerLoseService.selectlose(pn, size, customerLoseBean);
		  
		 map.put("selectAll", selectAll);
		 return "forward:/jsp/overtime.jsp";
	}
	


}
