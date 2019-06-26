package com.sc.crmsys.service;

import java.util.List;

import com.sc.crmsys.bean.FeedbackBean;

public interface FeedbackService {
	public List<FeedbackBean> getfeedback();
	public void addfeedback(FeedbackBean feedbackBean);
	
	
	public FeedbackBean get1feedback(String feedbackId);
	
	public void updatefeedback(FeedbackBean feedbackBean);
	
	
	public void delfeedback(String feedbackId);

}
