package com.sc.crmsys.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sc.crmsys.bean.StockBean;
import com.sc.crmsys.service.StockService;

@Controller
@RequestMapping("/stock")
public class StockController {
	
	@Resource
	private StockService stockService;
	@RequestMapping("/add")
	public String addStock(StockBean stockBean)
	{
		//使用UUID设置主键
		String id = UUID.randomUUID().toString();
		//stockBean.setStockNumber(id);
		stockBean.setCommodityNumber(id);
		stockService.addStock(stockBean);
		
		//跳转到查询controller
		return "redirect:/stock/select";
	}
	
	@RequestMapping("/select")
	public String selectstocks(Map<String, Object> map)
	{
		List<StockBean> selectStock = stockService.selectStock();
		map.put("selectStock", selectStock);
		return "forward:/jsp/wish.jsp";
		
	}
	@RequestMapping("selectId")
	public String selectStockId(String id,Map<String, Object> map)
	{
		StockBean selectByPrimaryKey = stockService.selectByPrimaryKey(id);
		map.put("selectByPrimaryKey", selectByPrimaryKey);
		return "forward:/jsp/updategoods.jsp";	
	}
	@RequestMapping("deleteId")
	public String deleteStockId(String commodityNumber)
	{
		System.out.println(commodityNumber);
		stockService.deleteByPrimaryKey(commodityNumber);
		return "redirect:select";
		
	}
	@RequestMapping("updateId")
	public String updateStockId(StockBean stockBean, Map<String, Object> map)
	{
		stockService.updateStockId(stockBean);
		return "redirect:/stock/select";
		
	}
	
	
	

}
