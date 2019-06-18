package com.sc.crmsys.mapper;

import com.sc.crmsys.bean.FeedbackBean;

public interface FeedbackBeanMapper {
    int deleteByPrimaryKey(String feedbackId);

    int insert(FeedbackBean record);

    int insertSelective(FeedbackBean record);

    FeedbackBean selectByPrimaryKey(String feedbackId);

    int updateByPrimaryKeySelective(FeedbackBean record);

    int updateByPrimaryKey(FeedbackBean record);
}