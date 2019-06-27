package com.sc.crmsys.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sc.crmsys.bean.DetailPurchaseBean;
import com.sc.crmsys.bean.OrderPurchaseBean;
import com.sc.crmsys.bean.SupplierBean;
import com.sc.crmsys.bean.UserBean;
import com.sc.crmsys.service.PurchaseOrderService;

@Controller
@RequestMapping("/purchaseOrder")
public class purchaseOrderController {

	@Resource
	private PurchaseOrderService purchaseOrderService;
	
	@RequestMapping("/select")
	public String getPurchaseOrder(HttpServletRequest req,Map<String, Object> data)
	{
		Subject subject = SecurityUtils.getSubject();
		UserBean userBean = (UserBean)subject.getPrincipal();
		
		
		List<OrderPurchaseBean> purchaseOrderList = purchaseOrderService.getPurchaseOrder(userBean.getCompanyId());
		data.put("purchaseOrderList", purchaseOrderList);
		return "forward:/jsp/purchaseOrder.jsp";
	}
	
	public String delPurchaseOrder(String orderPurchaseId)
	{
		purchaseOrderService.delPurchaseOrder(orderPurchaseId, new Date());
		return "redirect:/purchaseOrder/select";
	}
	
	public String addPurchaseOrder(OrderPurchaseBean orderPurchaseBean,SupplierBean supplierBean)
	{
		 //从session中取出公司标识ID
		Subject subject = SecurityUtils.getSubject();
		UserBean userBean = (UserBean)subject.getPrincipal();
		
		String orderPurchaseId = UUID.randomUUID().toString();
		String detailPurchaseId = UUID.randomUUID().toString();
		
		DetailPurchaseBean detailPurchaseBean = new DetailPurchaseBean();
		
		detailPurchaseBean.setDetailPurchaseId(detailPurchaseId);
		detailPurchaseBean.setOrderPurchaseId(orderPurchaseId);
		orderPurchaseBean.setOrderPurchaseId(orderPurchaseId);
		
		
		return "";
	}
	
}
