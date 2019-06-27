package com.sc.crmsys.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sc.crmsys.bean.SaleInfoBean;
import com.sc.crmsys.service.SaleinfoService;

@Controller
@RequestMapping("/saleinfo")
public class SaleinfoController {

	@Resource
	private SaleinfoService saleinfoService;
	
	
	@RequestMapping("/get")
	public String getsaleinfo(Map<String, Object> map)	
	{
	
		List<SaleInfoBean> getsaleinfo = saleinfoService.getsaleinfo();
		map.put("getsaleinfo", getsaleinfo);
		return "forward:/jsp/saleinfo.jsp";
	}
	
	@RequestMapping("/add")
	public String addsaleinfo(SaleInfoBean saleInfoBean)
	{
		saleinfoService.addsaleinfo(saleInfoBean);
		
		
		return "redirect:get";
	}
	
	@RequestMapping("/get1")
	public String get1saleinfo(String saleinfoId,Map<String, Object> map)
	{
		SaleInfoBean get1saleinfo = saleinfoService.get1saleinfo(saleinfoId);
		map.put("get1saleinfo", get1saleinfo);
		System.out.println(get1saleinfo.getSaleinfoId());
		return "forward:/jsp/get1saleinfo.jsp";
	}
	
	@RequestMapping("/update")
	public String updatesaleinfo(SaleInfoBean saleInfoBean)
	{
		saleinfoService.updatesaleinfo(saleInfoBean);
		return "redirect:get";
	}
	
	@RequestMapping("/del")
	public String  delsaleinfo(String saleinfoId)
	{
		saleinfoService.delsaleinfo(saleinfoId);
		return "redirect:get";
	}
}
