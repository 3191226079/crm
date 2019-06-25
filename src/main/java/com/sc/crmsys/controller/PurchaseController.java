package com.sc.crmsys.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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
import com.sc.crmsys.utils.DateFormatUtils;

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
		
	

		//从session中获得公司id
		Subject subject = SecurityUtils.getSubject();
		UserBean userBean = (UserBean)subject.getPrincipal();
		
		
		
		
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
		Subject subject = SecurityUtils.getSubject();
		UserBean userBean = (UserBean)subject.getPrincipal();
		
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
		purchaseBean.setCompanyId(userBean.getCompanyId());
		detailPurchaseBean.setCompanyId(userBean.getCompanyId());
		orderPurchaseBean.setCompanyId(userBean.getCompanyId());
		
		//记录修改时间
		purchaseBean.setPurchaseUpdateTime(new Date());
		detailPurchaseBean.setDetailPurchaseUpdateTime(new Date());
		orderPurchaseBean.setOrderPurchaseUpdateTime(new Date());
		
		
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
		purchaseBean.setPurchaseUpdateTime(new Date());
		detailPurchaseBean.setDetailPurchaseUpdateTime(new Date());
		orderPurchaseBean.setOrderPurchaseUpdateTime(new Date());
		System.out.println(detailPurchaseBean.getProductNum());
		purchaseService.updatePurchase(purchaseBean, detailPurchaseBean, orderPurchaseBean);
		data.put("purchaseId", purchaseBean.getPurchaseId());
		return "redirect:/purchase/select";
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
}
