package com.sc.crmsys.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.crmsys.bean.SupplierBean;
import com.sc.crmsys.bean.UserBean;
import com.sc.crmsys.service.SupplierService;

@Controller
@RequestMapping("/supplier")
public class SupplierController {
	
	@Resource
	private SupplierService supplierService;
	
	/**
	 * 查询所有供应商信息
	 * @param data
	 * @return
	 */
	@RequestMapping("/select")
	public String getSupplier(Map<String, Object> data)
	{
		List<SupplierBean> supplierList = supplierService.getSupplier();
		data.put("supplierList", supplierList);
		return "forward:/jsp/supplier.jsp";
	}
	
	/**
	 * 查看供应商详情
	 * @param data
	 * @param supplierId
	 * @return
	 */
	@RequestMapping("/find")
	public String findSupplier(Map<String, Object> data,String supplierId)
	{
		
		SupplierBean supplierBean = supplierService.findSupplier(supplierId);
		data.put("supplierBean", supplierBean);
		return "forward:/jsp/suplieru.jsp";
	}
	
	/**
	 * 修改供应商信息
	 * @param supplierBean
	 * @return
	 */
	@RequestMapping("/update")
	@ResponseBody
	public Map<String, Object> updateSupplier(SupplierBean supplierBean)
	{
		HashMap<String, Object> map = new HashMap<>();
		supplierBean.setSupplierUpdateTime(new Date());
		supplierService.updateSupplier(supplierBean);
		String msg = "修改成功";
		map.put("msg", msg);
		return map;
	}
	
	/**
	 * 删除供应商信息
	 * @param supplierId
	 * @return
	 */
	
	@RequestMapping("/del")
	@ResponseBody
	public Map<String, Object> delSupplier(String supplierId)
	{
		HashMap<String, Object> map = new HashMap<>(); 
		String success = "删除成功";
		map.put("success", success);
		
		supplierService.updateSupplierState(supplierId);
		return map;
	}
	
	/**
	 * 添加供应商信息
	 * @param supplierBean
	 * @return
	 */
	@RequestMapping("/add")
	public String addSupplier(SupplierBean supplierBean)
	{
		Subject subject = SecurityUtils.getSubject();
		UserBean userBean = (UserBean)subject.getPrincipal();
		
		supplierBean.setSupplierPerson(userBean.getUserName());
		supplierBean.setCompanyId(userBean.getCompanyId());
		
		String supplierId = UUID.randomUUID().toString();
		
		supplierBean.setSupplierId(supplierId);
		
		supplierBean.setSupplierUpdateTime(new Date());
		supplierBean.setSupplierState("1");
		
		supplierService.addSupplier(supplierBean);
		return "redirect:/supplier/select";
	}

}
