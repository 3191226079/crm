package com.sc.crmsys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.crmsys.bean.SaleInfoBean;
import com.sc.crmsys.bean.StockBean;
import com.sc.crmsys.service.StockService;

@Controller
@RequestMapping("/stock")
public class StockController {
	
	@Resource
	private StockService stockService;
	
	@RequiresPermissions("liuqi:production")
	@RequestMapping("/add")
	public String addStock(StockBean stockBean)
	{
		//使用UUID设置主键
		//ceshi
		String id = UUID.randomUUID().toString();
		//stockBean.setStockNumber(id);
		stockBean.setCommodityNumber(id);
		stockService.addStock(stockBean);
		
		//跳转到查询controller
		return "redirect:/stock/select";
	}
	
	@RequiresPermissions("liuqi:production")
	@RequestMapping("/select")
	public String selectstocks(Map<String, Object> map)
	{
		List<StockBean> selectStock = stockService.selectStock();
		map.put("selectStock", selectStock);
		return "forward:/jsp/wish.jsp";
		
	}
	
	@RequiresPermissions("liuqi:production")
	@RequestMapping("selectId")
	public String selectStockId(String id,Map<String, Object> map)
	{
		StockBean selectByPrimaryKey = stockService.selectByPrimaryKey(id);
		map.put("selectByPrimaryKey", selectByPrimaryKey);
		return "forward:/jsp/updategoods.jsp";	
	}
	
	@RequiresPermissions("liuqi:production")
	@RequestMapping("deleteId")
	public String deleteStockId(String commodityNumber)
	{
		System.out.println(commodityNumber);
		stockService.deleteByPrimaryKey(commodityNumber);
		return "redirect:select";
		
	}
	
	@RequiresPermissions("liuqi:production")
	@RequestMapping("updateId")
	public String updateStockId(StockBean stockBean,SaleInfoBean saleInfoBean, Map<String, Object> map)
	{
		stockService.updateStockId(stockBean,saleInfoBean);
		return "redirect:/stock/select";
		
	}
	
	@RequiresPermissions("liuqi:production")
	@RequestMapping("/getstock")
	public String getstocks(Map<String, Object> map)
	{
		List<StockBean> getStock = stockService.selectStock();
		map.put("getStock", getStock);
		return "forward:/jsp/outsaleinfo.jsp";
		
	}
	
	//查询价格
	@RequiresPermissions("liuqi:production")
	@RequestMapping("/selectPrice")
	@ResponseBody
	public Map<String, Object> selectStockPrice(String num)
	{
		StockBean se = stockService.selectByPrimaryKey(num);
		HashMap<String,Object> map = new HashMap<>();
		map.put("se", se);
		return map;	
	}
	
	//查询商品数量
	@RequiresPermissions("liuqi:outorder")
	@RequestMapping("/outStock")
	public String selectStockNum(SaleInfoBean saleInfoBean,Map<String, Object> map)
	{
		StockBean stockBean = stockService.selectByPrimaryKey(saleInfoBean.getGoodsId());
		String number = stockBean.getStockNumber();
		/*String number = stockBean.getCommodityNumber();*/
		Integer inNumber = Integer.valueOf(number);
		
		String goodsNum = saleInfoBean.getGoodsNum();
		
		if(inNumber > Integer.valueOf(goodsNum))
		{
			Integer realNumber = inNumber-Integer.valueOf(goodsNum);
			stockBean.setStockNumber(realNumber.toString());
			stockService.updateStockId(stockBean,saleInfoBean);
			return "forward:/inc/mainll.jsp";	
		}
		else
		{
			map.put("fail", "库存不足");
		}
		return "forward:/saleout/get";	
	}
	
	

}
