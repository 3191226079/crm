package com.sc.crmsys.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sc.crmsys.bean.WarehouseBean;
import com.sc.crmsys.service.WarehouseService;

@Controller
@RequestMapping("/addgd")
public class WarehouseController {
	@Resource
	private WarehouseService warehouseService;
	
	@RequestMapping("/select")
	public String selectWhNumber(String warehouseNumber,Map<String, Object> map)
	{
		WarehouseBean selectWarehouseNumber =warehouseService.selectWarehouseNumber(warehouseNumber);
		map.put("selectWarehouseNumber", selectWarehouseNumber);
		/*System.out.println(selectWarehouseNumber);*/
		return "";
		
	}
	
	@RequestMapping("/selectAll")
	public String selectAll(Map<String, Object> map)
	{
		List<WarehouseBean> selectWarehouse = warehouseService.selectWarehouse();
		map.put("selectWarehouse", selectWarehouse);
		return "forward:/jsp/addgoods.jsp";
		
		
	}
	
	

}
