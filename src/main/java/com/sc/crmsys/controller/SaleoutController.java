package com.sc.crmsys.controller;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sc.crmsys.bean.SaleOutBean;
import com.sc.crmsys.bean.StockBean;
import com.sc.crmsys.service.SaleoutService;
import com.sc.crmsys.service.StockService;

@Controller
@RequestMapping("/saleout")
public class SaleoutController {
	
	@Resource
	private SaleoutService saleoutService;
	
	@Resource
	private StockService stockService; 
	
	
	@RequestMapping("/get")
	public String getsaleout(String fail, Map<String, Object> map)
	{
		List<SaleOutBean> getsaleout = saleoutService.getsaleout();
		List<StockBean> getStock = stockService.selectStock();
		map.put("getsaleout", getsaleout);
		map.put("getStock", getStock);
		map.put("fail", fail);
		return "forward:/jsp/outsaleinfo.jsp";
	}
	
	
	@RequestMapping("/add")
	public String addsaleout(SaleOutBean saleOutBean)
	{
		//使用UUID设置主键
		String id = UUID.randomUUID().toString();
		saleOutBean.setSaleoutId(id);
		
		Date date = new Date();
		saleOutBean.setSaleoutTime(date);
		
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
	
	@RequestMapping("/selectSale")
	public String selectSaleout(Map<String, Object> map)
	{
		List<SaleOutBean> saleOutId = saleoutService.getSaleOutId();
		map.put("saleOutId", saleOutId);
		return "forward:/jsp/outsaleinfo.jsp";
		
	}
	
	@RequestMapping("/getSale")
	public String getSaleoutStock(Map<String, Object> map)
	{
		List<SaleOutBean> selectSaleStock = saleoutService.selectSaleStock();
		System.out.println(selectSaleStock);
		map.put("selectSaleStock", selectSaleStock);
		return "forward:/jsp/outsaleinfo.jsp";
		
	}
	@RequestMapping("/gSS")
	public String getSaleS(Map<String, Object> map)
	{
		List<SaleOutBean> sss = saleoutService.getSSS();
		
		/*for (Iterator iterator = sss.iterator(); iterator.hasNext();) {
			SaleOutBean saleOutBean = (SaleOutBean) iterator.next();
		}*/
		map.put("sss", sss);
		return "forward:/jsp/outsaleinfo.jsp";
		
	}
	
}
