package com.sc.crmsys.service;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.CustomerBean;
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
		
		String token = UUID.randomUUID().toString();
		feedbackbean.setFeedbackId(token);
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

	@Override
	public PageInfo<FeedbackBean> selectAll(Integer pn, Integer size, FeedbackBean feedbackBean) {
		PageHelper.startPage(pn, size); 
		List<FeedbackBean> getcustomername = feedbackBeanMapper.getcustomername();
	
		
	
	
	
	
		return new PageInfo<FeedbackBean>(getcustomername);
	}

	
}
