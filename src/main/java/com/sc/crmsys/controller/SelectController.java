package com.sc.crmsys.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sc.crmsys.bean.CustomerBean;
import com.sc.crmsys.service.OneMonthService;
import com.sc.crmsys.service.SevenDayService;
import com.sc.crmsys.service.ThreeDayService;
import com.sc.crmsys.service.TodayService;



@Controller
@RequestMapping("/today")
public class SelectController {
	
	@Resource
	private TodayService todayService;
	
	@Resource
	private ThreeDayService threeDayService;
	
	@Resource
	private SevenDayService sevenDayService;
	
	@Resource
	private OneMonthService oneMonthService;
	
	@RequestMapping("/gettoday")
	public String getToday(Map<String, Object> map)
	{
	
		List<CustomerBean> selectToday = todayService.selectToday();
		System.out.println(selectToday);
		System.out.println("wwwwwwwww");
		map.put("selectToday", selectToday);
		return "forward:/jsp/today.jsp";
		
	}
	
	@RequestMapping("/getthreeday")
	public String getthreeday(Map<String, Object> map)
	{
		List<CustomerBean> getthreeday = threeDayService.getthreeday();
		map.put("getthreeday", getthreeday);
		return "forward:/jsp/threeday.jsp";
	}
	
	@RequestMapping("/getsevenday")
	public String getsevenday(Map<String, Object> map)
	{
		List<CustomerBean> getsevenday = sevenDayService.getsevenday();
		map.put("getsevenday", getsevenday);
		return "forward:/jsp/sevenday.jsp";
	}
	
	@RequestMapping("/getonemonthday")
	public String getonemonthday(Map<String , Object> map)
	{
		List<CustomerBean> getonemonth = oneMonthService.getonemonth();
		map.put("getonemonth", getonemonth);
		return "forward:/jsp/onemonth.jsp";
	}
	
}
