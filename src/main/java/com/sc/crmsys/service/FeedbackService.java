package com.sc.crmsys.service;

import java.util.List;

import com.sc.crmsys.bean.FeedbackBean;

public interface FeedbackService {
	public List<FeedbackBean> getfeedback();
	public void addfeedback(FeedbackBean feedbackBean);

}
