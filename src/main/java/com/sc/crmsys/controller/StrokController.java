package com.sc.crmsys.controller;



import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sc.crmsys.bean.StockBean;
import com.sc.crmsys.service.StockService;

@Controller
@RequestMapping("/StockBean")
public class StrokController {
	@Resource
	private StockService stockService;
	
	
	
	
	
	

}
