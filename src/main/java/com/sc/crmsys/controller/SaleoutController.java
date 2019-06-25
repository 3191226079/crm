package com.sc.crmsys.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sc.crmsys.bean.SaleOutBean;
import com.sc.crmsys.service.SaleoutService;

@Controller
@RequestMapping("/saleout")
public class SaleoutController {
	
	@Resource
	private SaleoutService saleoutService;
	
	
	@RequestMapping("/get")
	public String getsaleout(Map<String, Object> map)
	{
		List<SaleOutBean> getsaleout = saleoutService.getsaleout();
		map.put("getsaleout", getsaleout);
		
		
		return "forward:/jsp/saleout.jsp";
	}
	
	
	@RequestMapping("/add")
	public String addsaleout(SaleOutBean saleOutBean)
	{
		saleoutService.addsaleout(saleOutBean);
		return "redirect:get";
		
	}
	
	@RequestMapping("/get1")
	public String get1saleout(String saleoutId,Map<String, Object> map)
	{
		SaleOutBean saleout = saleoutService.get1ssaleout(saleoutId);
		map.put("saleout", saleout);
		return "forward:/jsp/get1saleout.jsp";
	}
	
	@RequestMapping("/update")
	public String updatesaleout(SaleOutBean saleOutBean)
	{
		saleoutService.updatesaleout(saleOutBean);
		return "redirect:get";
	}
	
	@RequestMapping("/del")
	public String delsaleout(String saleoutId)
	{
		saleoutService.delsaleout(saleoutId);
		return "redirect:get";
	}
}
