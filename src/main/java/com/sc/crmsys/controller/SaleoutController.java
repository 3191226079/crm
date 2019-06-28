package com.sc.crmsys.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
		//使用UUID设置主键
		String id = UUID.randomUUID().toString();
		saleOutBean.setSaleoutId(id);
		
		Date date = new Date();
		saleOutBean.setSaleoutTime(date);
		
		System.out.println(saleOutBean.getSaleoutId());
		saleoutService.addsaleout(saleOutBean);
		return "redirect:/jsp/outsaleinfo.jsp";
		
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
	
	@RequestMapping("selectSale")
	public String selectSaleout(Map<String, Object> map)
	{
		List<SaleOutBean> saleOutId = saleoutService.getSaleOutId();
		map.put("saleOutId", saleOutId);
		return "forward:/jsp/outsaleinfo.jsp";
		
	}
	
	/*@RequestMapping("getSale")
	public String getSaleout(Map<String, Object> map)
	{
		List<SaleOutBean> getOutId = saleoutService.getSaleOutId();
		map.put("getOutId", getOutId);
		return "forward:/jsp/outsaleinfo.jsp";
		
	}*/
}
