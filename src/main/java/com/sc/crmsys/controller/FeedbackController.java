package com.sc.crmsys.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.CustomerBean;
import com.sc.crmsys.bean.FeedbackBean;
import com.sc.crmsys.service.FeedbackService;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {
	
	@Resource
	private FeedbackService feedbackService;
	
	
	
/*	@RequestMapping("/getfeedback")
	public String getfeedback1(Map<String , Object> map)
	{
		List<FeedbackBean> getfeedback = feedbackService.getfeedback();
		map.put("getfeedback", getfeedback);
	
		return "forward:/jsp/feedback.jsp";
	}
	*/
	@RequiresPermissions("kunda:customermanage")
	@RequestMapping("/getfeedback")
	public String selectInfo(@RequestParam(defaultValue="1")Integer pn,@RequestParam(defaultValue="5")Integer size,FeedbackBean feedbackBean,Map<String, Object> map)
	{
		if(feedbackBean == null)
		{
			feedbackBean = new FeedbackBean();
		}
		
		
		
		PageInfo<FeedbackBean> getfeedback = feedbackService.selectAll(pn, size, feedbackBean);
		
		 
		 
		 map.put("getfeedback", getfeedback);
		 return "forward:/jsp/feedback.jsp";
		  
	}
	
	
	
	@RequiresPermissions("kunda:customermanage")
	@RequestMapping("/addfeedback")
	public String addfeedback(FeedbackBean feedbackBean)
	{
		feedbackService.addfeedback(feedbackBean);
		return "redirect:getfeedback";
	}

	@RequiresPermissions("kunda:customermanage")
	@RequestMapping("/get1")
	public String get1feedback(String feedbackId,Map<String, Object> map)
	{
		FeedbackBean get1feedback = feedbackService.get1feedback(feedbackId);
		map.put("get1feedback", get1feedback);
		return "forward:/jsp/get1feedback.jsp";
	}
	
	@RequiresPermissions("kunda:customermanage")
	@RequestMapping("/update")
	public String updatefeedback(FeedbackBean feedbackBean)
	{
		feedbackService.updatefeedback(feedbackBean);
		return "redirect:getfeedback";
	}
	
	@RequiresPermissions("kunda:customermanage")
	@RequestMapping("/del")
	public String delfeedback(String feedbackId)
	{
		feedbackService.delfeedback(feedbackId);
		return "redirect:getfeedback";
	}
	
	
	@RequiresPermissions("kunda:customermanage")
	@RequestMapping("/zhuan")
	public String zhaun(String customerId,Map<String, Object> map)
	{
	FeedbackBean feedbackBean = new FeedbackBean();
	feedbackBean.setCustomerId(customerId);
	map.put("feedbackBean", feedbackBean);
	
	return "forward:/jsp/addfeedback.jsp";	
		
	}
}
