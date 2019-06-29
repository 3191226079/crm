package com.sc.crmsys.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.crmsys.bean.DetailPurchaseBean;
import com.sc.crmsys.bean.OrderPurchaseBean;
import com.sc.crmsys.bean.PurchaseBean;
import com.sc.crmsys.bean.StockBean;
import com.sc.crmsys.service.PurchaseService;
import com.sc.crmsys.service.StockService;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {

	
	
	@Resource
	private PurchaseService purchaseService;
	
	@Resource
	private StockService stockService;
	
	/**
	 * 查询该公司需采购的产品，即补货表
	 * @param companyId
	 * @param data
	 * @return
	 */
	@RequestMapping("/select")
	public String getPurchase(Map<String, Object> data)
	{
		List<PurchaseBean> purchaseList = purchaseService.getPurchase();
		data.put("purchaseList", purchaseList);
		return "forward:/jsp/opinion.jsp";
	}
	
	/**
	 * 添加需要补给的产品的信息
	 * @param data
	 * @param purchaseBean
	 * @param detailPurchaseBean
	 * @param orderPurchaseBean
	 * @return
	 */
	@RequestMapping("/add")
	public String addPurchase(Map<String, Object> data,PurchaseBean purchaseBean)
	{
		
		 //生成唯一标识主键
		String purchaseId = UUID.randomUUID().toString();
	
		//插入唯一标识主键和外键
		purchaseBean.setPurchaseId(purchaseId);
		
		//记录修改时间
		purchaseBean.setPurchaseUpdateTime(new Date());	
		
		purchaseBean.setPurchaseState("0");
		purchaseService.addPurchase(purchaseBean);
		
		return "redirect:/purchase/select";
	}
	
	
	/**
	 * 查看需补货产品详情
	 * @param purchaseId
	 * @param data
	 * @return
	 */
	@RequestMapping("/find")
	public String findPurchase(String purchaseId,Map<String, Object> data)
	{
		
		List<PurchaseBean> purchaseList = purchaseService.findPurchase(purchaseId);
		data.put("purchaseList",purchaseList);
		return "forward:/jsp/banner.jsp";
	}
	
	/**
	 * 修改需补给产品详情表信息
	 * @param data
	 * @param purchaseBean
	 * @param detailPurchaseBean
	 * @param orderPurchaseBean
	 * @return
	 */
	@RequestMapping("/update")
	@ResponseBody
	public Map<String, Object> updatePurchase(PurchaseBean purchaseBean,DetailPurchaseBean detailPurchaseBean,OrderPurchaseBean orderPurchaseBean)
	{
		System.out.println(purchaseBean.getPurchaseId());
		System.err.println(purchaseBean.getPurchaseInfo());
		HashMap<String, Object> data = new HashMap<>();
		purchaseBean.setPurchaseUpdateTime(new Date());
		detailPurchaseBean.setDetailPurchaseUpdateTime(new Date());
		orderPurchaseBean.setOrderPurchaseUpdateTime(new Date());
		purchaseService.updatePurchase(purchaseBean, detailPurchaseBean, orderPurchaseBean);
		String success = "修改成功";
		data.put("success",success);
		return data;
	}
	/**
	 * 删除表单
	 * @param purchaseId
	 * @return
	 */
	@RequestMapping("/del")
	public String delPurchase(String purchaseId)
	{
		purchaseService.updatePurchaseState(purchaseId,new Date());
		return "redirect:/purchase/select";
	}
	

	@RequestMapping("selectAll")
	public String selectAll(Map<String, Object> data,PurchaseBean purchaseBean)
	{
		List<PurchaseBean> selcetPurchaseAll = purchaseService.selcetPurchaseAll(purchaseBean);
		data.put("selcetPurchaseAll", selcetPurchaseAll);
		return null;
		
	}

	@RequestMapping("/getStockes")
	public String getStockes(Map<String, Object> data)
	{
		List<StockBean> stockes = stockService.getStockes();
		data.put("stockes", stockes);
		return "forward:/jsp/banneradd.jsp";
	}
	

}
