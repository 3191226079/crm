package com.sc.crmsys.mapper;

import java.util.List;

import com.sc.crmsys.bean.FeedbackBean;

public interface FeedbackBeanMapper {
    int deleteByPrimaryKey(String feedbackId);

    int insert(FeedbackBean record);

    void insertSelective(FeedbackBean feedbackBean);

    FeedbackBean selectByPrimaryKey(String feedbackId);

    int updateByPrimaryKeySelective(FeedbackBean record);

    int updateByPrimaryKey(FeedbackBean record);
    
    public List<FeedbackBean> getfeedback();
}