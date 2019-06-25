package com.sc.crmsys.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sc.crmsys.bean.FeedbackBean;
import com.sc.crmsys.mapper.FeedbackBeanMapper;

@Service("feedbackService")
public class FeedbackServiceImpl implements FeedbackService{
	
	@Resource
	private FeedbackBeanMapper feedbackBeanMapper;

	@Override
	public List<FeedbackBean> getfeedback() {
		List<FeedbackBean> getfeedback = feedbackBeanMapper.getfeedback();
		return getfeedback;
	}

	@Override
	public void addfeedback( FeedbackBean feedbackbean) {
		feedbackBeanMapper.insertSelective(feedbackbean);
	}

}
