package com.sc.crmsys.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sc.crmsys.bean.SaleInfoBean;
import com.sc.crmsys.service.SaleinfoService;

@Controller
@RequestMapping("/saleinfo")
public class SaleinfoController {

	@Resource
	private SaleinfoService saleinfoService;
	
	@RequiresPermissions("liuqi:outorder")
	@RequestMapping("/get")
	public String getsaleinfo(Map<String, Object> map)	
	{
	
		List<SaleInfoBean> getsaleinfo = saleinfoService.getsaleinfo();
		map.put("getsaleinfo", getsaleinfo);
		return "forward:/jsp/saleinfo.jsp";
	}
	
	@RequiresPermissions("liuqi:outorder")
	@RequestMapping("/add")
	public String addsaleinfo(SaleInfoBean saleInfoBean)
	{
		//使用UUID设置主键
		String id = UUID.randomUUID().toString();
		saleInfoBean.setSaleinfoId(id);
		saleInfoBean.setSaleinfoLastTime(new Date());
		saleinfoService.addsaleinfo(saleInfoBean);
		return "redirect:/user/index";
	}
	
	@RequiresPermissions("liuqi:outorder")
	@RequestMapping("/get1")
	public String get1saleinfo(String saleinfoId,Map<String, Object> map)
	{
		SaleInfoBean get1saleinfo = saleinfoService.get1saleinfo(saleinfoId);
		map.put("get1saleinfo", get1saleinfo);
		System.out.println(get1saleinfo.getSaleinfoId());
		return "forward:/jsp/get1saleinfo.jsp";
	}
	
	@RequiresPermissions("liuqi:outorder")
	@RequestMapping("/update")
	public String updatesaleinfo(SaleInfoBean saleInfoBean)
	{
		saleinfoService.updatesaleinfo(saleInfoBean);
		return "redirect:get";
	}
	
	@RequiresPermissions("liuqi:outorder")
	@RequestMapping("/del")
	public String  delsaleinfo(String saleinfoId)
	{
		saleinfoService.delsaleinfo(saleinfoId);
		return "redirect:get";
	}
}
