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

	@Override
	public FeedbackBean get1feedback(String feedbackId) {
		FeedbackBean selectByPrimaryKey = feedbackBeanMapper.selectByPrimaryKey(feedbackId);
		
		return selectByPrimaryKey;
	}

	@Override
	public void updatefeedback(FeedbackBean feedbackBean) {
		feedbackBeanMapper.updateByPrimaryKeySelective(feedbackBean);
		
	}

	@Override
	public void delfeedback(String feedbackId) {
		feedbackBeanMapper.deleteByPrimaryKey(feedbackId);
		
	}

}
