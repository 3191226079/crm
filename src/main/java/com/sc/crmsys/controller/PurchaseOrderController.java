package com.sc.crmsys.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.crmsys.bean.DetailPurchaseBean;
import com.sc.crmsys.bean.OrderPurchaseBean;
import com.sc.crmsys.bean.StockBean;
import com.sc.crmsys.bean.SupplierBean;
import com.sc.crmsys.service.DetailPurchaseService;
import com.sc.crmsys.service.PurchaseOrderService;
import com.sc.crmsys.service.StockService;
import com.sc.crmsys.service.SupplierService;

@Controller
@RequestMapping("/purchaseOrder")
public class PurchaseOrderController {

	@Resource
	private PurchaseOrderService purchaseOrderService;
	
	@Resource
	private SupplierService supplierService;
	
	@Resource
	private StockService stockService;
	
	@Resource
	private DetailPurchaseService detailPurchaseService;
	
	@RequestMapping("/select")
	public String getPurchaseOrder(Map<String, Object> data)
	{
		List<OrderPurchaseBean> purchaseOrderList = purchaseOrderService.getPurchaseOrder();
		data.put("purchaseOrderList", purchaseOrderList);
		return "forward:/jsp/purchaseOrder.jsp";
	}
	@ResponseBody
	@RequestMapping("/del")
	public Map<String, Object> delPurchaseOrder(String orderPurchaseId)
	{
		HashMap<String, Object> map = new HashMap<>();
		
		
		purchaseOrderService.delPurchaseOrder(orderPurchaseId, new Date());
		String msg = "删除成功";
		map.put("msg", msg);
		return map;
	}
	
	
	
	@RequestMapping("/getSuppliers")
	public String getSuppliers(Map<String, Object> data)
	{
		List<SupplierBean> supplierList = supplierService.getSupplier();
		List<StockBean> stockList = stockService.getStockes();
		data.put("stockList", stockList);
		data.put("supplierList", supplierList);
		return "forward:/jsp/connoisseuradd.jsp";
	}
	
	@RequestMapping("/getSupplier")
	@ResponseBody
	public Map<String, Object> getSupplier(String supplierId)
	{
		HashMap<String, Object> map = new HashMap<>();
		SupplierBean supplierBean = supplierService.findSupplier(supplierId);
		map.put("supplierBean", supplierBean);
		
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/getStock")
	public Map<String, Object> getStock(String commodityNumber)
	{
		HashMap<String, Object> map = new HashMap<>();
		StockBean stockBean = stockService.getStock(commodityNumber);
		map.put("stockBean", stockBean);
		return map;
	}
	
	@RequestMapping("/find")
	public String find(Map<String, Object> data,String orderPurchaseId)
	{
		OrderPurchaseBean orderPurchaseBean = purchaseOrderService.find(orderPurchaseId);
		data.put("orderPurchaseBean", orderPurchaseBean);
		return "forward:/jsp/connoisseur.jsp";
	}
	
	@ResponseBody
	@RequestMapping("/add")
	public Map<String, Object> addPurchaseOrder(@RequestBody OrderPurchaseBean orderPurchaseBean)
	{
		HashMap<String, Object> map = new HashMap<>();
		String orderPurchaseId = UUID.randomUUID().toString();
		orderPurchaseBean.setOrderPurchaseState("0");
		orderPurchaseBean.setOrderPurchaseId(orderPurchaseId);
		orderPurchaseBean.setOrderPurchaseUpdateTime(new Date());
		purchaseOrderService.addPurchaseOrder(orderPurchaseBean);
		
		List<DetailPurchaseBean> detailPurchaseList = orderPurchaseBean.getDetailPurchaseList();
		
		for (int i = 0; i <detailPurchaseList.size(); i++) {
			DetailPurchaseBean detailPurchaseBean = detailPurchaseList.get(i);
			String detailPurchaseId = UUID.randomUUID().toString();
			detailPurchaseBean.setOrderPurchaseId(orderPurchaseId);
			detailPurchaseBean.setDetailPurchaseState("0");
			detailPurchaseBean.setDetailPurchaseUpdateTime(new Date());
			detailPurchaseBean.setDetailPurchaseId(detailPurchaseId);
			detailPurchaseService.addDetail(detailPurchaseBean);
		}
		
		String success = "添加成功";
		map.put("success", success);
		return map;
	}
	
	
}
