package com.sc.crmsys.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.crmsys.bean.CustomerBean;
import com.sc.crmsys.bean.CustomerLoseBean;
import com.sc.crmsys.service.CustomerLoseService;

@Controller
@RequestMapping("/customerlose")
public class CustomerLoseController {
	
	@Resource
	private CustomerLoseService customerLoseService;
	
	
	@RequestMapping("/getcustomerlose")
	
	public String getcustomerlose(Map<String, Object> map)
	{
		List<CustomerLoseBean> customerlose = customerLoseService.getcustomerlose();
		map.put("customerlose", customerlose);
		return "forward:/jsp/customerlose.jsp";
	}
	
	@RequestMapping("/select")
	public String select(String customerLoseId,Map<String, Object> map)
	{
			
		
		CustomerLoseBean selectcustomerlose = customerLoseService.selectcustomerlose(customerLoseId);
		map.put("selectcustomerlose", selectcustomerlose);
		
		return "forward:/jsp/selectcustomerlose.jsp";
	}
	
	@RequestMapping("/select1")
	public String select1(String customerLoseId,Map<String, Object> map)
	{
			
		
		CustomerLoseBean selectcustomerlose = customerLoseService.selectcustomerlose(customerLoseId);
		map.put("selectcustomerlose", selectcustomerlose);
		
		return "forward:/jsp/selectcustomerlose1.jsp";
	}
	
	@RequestMapping("/update")
	public String update(CustomerLoseBean customer)
	{
		 customerLoseService.updatecustomerlose(customer);
		return "redirect:getcustomerlose";
	}
	
	
	@RequestMapping("/update1")
	public String update1(CustomerLoseBean customer)
	{
		 customerLoseService.updatecustomerlose(customer);
		return "redirect:getconfirmationofloss";
	}
	
	@RequestMapping("/getconfirmationofloss")
	public String getconfirmationofloss(Map<String, Object> map)
	{
		List<CustomerLoseBean> confirmationofloss = customerLoseService.confirmationofloss();
		map.put("confirmationofloss", confirmationofloss);
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

}
