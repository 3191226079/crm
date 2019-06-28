package com.sc.crmsys.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.crmsys.bean.DetailPurchaseBean;
import com.sc.crmsys.bean.OrderPurchaseBean;
import com.sc.crmsys.bean.StockBean;
import com.sc.crmsys.bean.SupplierBean;
import com.sc.crmsys.bean.UserBean;
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
	
	@RequestMapping("/select")
	public String getPurchaseOrder(HttpServletRequest req,Map<String, Object> data)
	{
		List<OrderPurchaseBean> purchaseOrderList = purchaseOrderService.getPurchaseOrder();
		data.put("purchaseOrderList", purchaseOrderList);
		return "forward:/jsp/purchaseOrder.jsp";
	}
	
	@RequestMapping("/del")
	public String delPurchaseOrder(String orderPurchaseId)
	{
		purchaseOrderService.delPurchaseOrder(orderPurchaseId, new Date());
		return "redirect:/purchaseOrder/select";
	}
	
	@ResponseBody
	@RequestMapping("/add")
	public Map<String, Object> addPurchaseOrder(OrderPurchaseBean orderPurchaseBean)
	{
		
		HashMap<String, Object> map = new HashMap<>();
		String orderPurchaseId = UUID.randomUUID().toString();
		orderPurchaseBean.setOrderPurchaseId(orderPurchaseId);
		orderPurchaseBean.setOrderPurchaseUpdateTime(new Date());
		purchaseOrderService.addPurchaseOrder(orderPurchaseBean);
		
		map.put("orderPurchaseId", orderPurchaseId);
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
	
	public String update()
	{
		
		
		return "";
	}
	
	@RequestMapping("/find")
	public String find(Map<String, Object> data,String orderPurchaseId)
	{
		OrderPurchaseBean orderPurchaseBean = purchaseOrderService.find(orderPurchaseId);
		data.put("orderPurchaseBean", orderPurchaseBean);
		return "forward:/jsp/connoisseur.jsp";
	}
	
	public Map<String, Object> addDetail(DetailPurchaseBean detailPurchaseBean)
	{
		HashMap<String, Object> map = new HashMap<>();
		return map;
	}
	
}
