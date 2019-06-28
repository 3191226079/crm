package com.sc.crmsys.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sc.crmsys.bean.SupplierBean;
import com.sc.crmsys.service.SupplierService;

@Controller
@RequestMapping("/supplier")
public class SupplierController {
	
	@Resource
	private SupplierService supplierService;
	
	@RequestMapping("/select")
	public String getSupplier(Map<String, Object> data)
	{
		List<SupplierBean> supplierList = supplierService.getSupplier();
		data.put("supplierList", supplierList);
		return "";
	}
	
	@RequestMapping("/find")
	public String findSupplier(Map<String, Object> data,String supplierId)
	{
		
		SupplierBean supplierBean = supplierService.findSuplier(supplierId);
		data.put("supplierBean", supplierBean);
		return "";
	}
	
	public String updateSupplier(SupplierBean supplierBean)
	{
		
		return "";
	}

}
