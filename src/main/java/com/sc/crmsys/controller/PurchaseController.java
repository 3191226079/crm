package com.sc.crmsys.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sc.crmsys.bean.DetailPurchaseBean;
import com.sc.crmsys.bean.OrderPurchaseBean;
import com.sc.crmsys.bean.PurchaseBean;
import com.sc.crmsys.bean.StockBean;
import com.sc.crmsys.service.PurchaseService;
import com.sc.crmsys.service.StockService;
import com.sc.crmsys.service.WarehouseService;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {

	
	
	@Resource
	private PurchaseService purchaseService;
	
	/**
	 * 通过公司ID查询该公司需采购的产品，即补货表
	 * @param companyId
	 * @param data
	 * @return
	 */
	@RequestMapping("/select")
	public String getPurchase(String companyId,Map<String, Object> data)
	{
		List<PurchaseBean> purchaseList = purchaseService.getPurchase(companyId);
		data.put("purchaseList", purchaseList);
		
		return "redirect:/jsp/opinion.jsp";
	}
	
	@RequestMapping("/add")
	public String addPurchase(Map<String, Object> data,PurchaseBean purchaseBean,DetailPurchaseBean detailPurchaseBean,OrderPurchaseBean orderPurchaseBean)
	{
		
		purchaseService.addPurchase(purchaseBean, detailPurchaseBean, orderPurchaseBean);
		
		return "redirect:/purchase/select";
	}
}
