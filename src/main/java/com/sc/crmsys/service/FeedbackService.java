package com.sc.crmsys.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.CustomerBean;
import com.sc.crmsys.bean.FeedbackBean;

public interface FeedbackService {
	public List<FeedbackBean> getfeedback();
	public void addfeedback(FeedbackBean feedbackBean);
	
	
	public FeedbackBean get1feedback(String feedbackId);
	
	public void updatefeedback(FeedbackBean feedbackBean);
	public void delfeedback(String feedbackId);
	
	
	public PageInfo<FeedbackBean> selectAll(Integer pn,Integer size,FeedbackBean feedbackBean);
	
	
	
	/*public List<FeedbackBean> getcustomername();*/

}
