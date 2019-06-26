package com.sc.crmsys.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sc.crmsys.bean.FeedbackBean;
import com.sc.crmsys.service.FeedbackService;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {
	
	@Resource
	private FeedbackService feedbackService;
	
	
	
	@RequestMapping("/getfeedback")
	public String getfeedback1(Map<String , Object> map)
	{
		List<FeedbackBean> getfeedback = feedbackService.getfeedback();
		map.put("getfeedback", getfeedback);
	
		return "forward:/jsp/feedback.jsp";
	}
	
	@RequestMapping("/addfeedback")
	public String addfeedback(FeedbackBean feedbackBean)
	{
		feedbackService.addfeedback(feedbackBean);
		return "redirect:getfeedback";
	}

	@RequestMapping("/get1")
	public String get1feedback(String feedbackId,Map<String, Object> map)
	{
		FeedbackBean get1feedback = feedbackService.get1feedback(feedbackId);
		map.put("get1feedback", get1feedback);
		return "forward:/jsp/get1feedback.jsp";
	}
	
	@RequestMapping("/update")
	public String updatefeedback(FeedbackBean feedbackBean)
	{
		feedbackService.updatefeedback(feedbackBean);
		return "redirect:getfeedback";
	}
	
	
	@RequestMapping("/del")
	public String delfeedback(String feedbackId)
	{
		feedbackService.delfeedback(feedbackId);
		return "redirect:getfeedback";
	}
}
