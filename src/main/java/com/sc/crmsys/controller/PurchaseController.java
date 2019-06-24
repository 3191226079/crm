package com.sc.crmsys.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sc.crmsys.bean.DetailPurchaseBean;
import com.sc.crmsys.bean.OrderPurchaseBean;
import com.sc.crmsys.bean.PurchaseBean;
import com.sc.crmsys.bean.StockBean;
import com.sc.crmsys.bean.UserBean;
import com.sc.crmsys.mapper.PurchaseBeanMapper;
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
	public String getPurchase(HttpServletRequest req,Map<String, Object> data)
	{
		//模拟session
		UserBean userBean2 = new UserBean();
		userBean2.setCompanyId("1");
		userBean2.setUserName("张三");
		HttpSession session = req.getSession();
		session.setAttribute("userBean", userBean2);
		
		
		
		UserBean userBean = (UserBean)req.getSession().getAttribute("userBean");
		List<PurchaseBean> purchaseList = purchaseService.getPurchase(userBean.getCompanyId());
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
	public String addPurchase(HttpServletRequest req,Map<String, Object> data,PurchaseBean purchaseBean,DetailPurchaseBean detailPurchaseBean,OrderPurchaseBean orderPurchaseBean)
	{
		 //从session中取出公司标识ID
		String companyId = (String)req.getSession().getAttribute("companyId");
		
		 //生成唯一标识主键
		String purchaseId = UUID.randomUUID().toString();
		String DetailPurchaseId = UUID.randomUUID().toString();
		String setOrderPurchaseId = UUID.randomUUID().toString();
		
	
		//插入唯一标识主键和外键
		purchaseBean.setPurchaseId(purchaseId);
		orderPurchaseBean.setOrderPurchaseId(setOrderPurchaseId);
		detailPurchaseBean.setDetailPurchaseId(DetailPurchaseId);
		detailPurchaseBean.setOrderPurchaseId(setOrderPurchaseId);
		
		
		//插入公司ID标识
		purchaseBean.setCompanyId(companyId);
		detailPurchaseBean.setCompanyId(companyId);
		orderPurchaseBean.setCompanyId(companyId);
		
		purchaseService.addPurchase(purchaseBean,detailPurchaseBean,orderPurchaseBean);
		
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
	public String updatePurchase(Map<String, Object> data,PurchaseBean purchaseBean,DetailPurchaseBean detailPurchaseBean,OrderPurchaseBean orderPurchaseBean)
	{
		System.out.println("aaa");
		purchaseService.updatePurchase(purchaseBean, detailPurchaseBean, orderPurchaseBean);
		data.put("purchaseId", purchaseBean.getPurchaseId());
		return "redirect:/purchase/find";
	}
	
	@RequestMapping("/del")
	public String delPurchase(String purchaseId)
	{
		purchaseService.updatePurchaseState(purchaseId,new Date());
		return "redirect:/purchase/select";
	}
}
