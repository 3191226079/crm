package com.sc.crmsys.mapper;

import com.sc.crmsys.bean.QuestionBean;

public interface QuestionBeanMapper {
    int deleteByPrimaryKey(String questionId);

    int insert(QuestionBean record);

    int insertSelective(QuestionBean record);

    QuestionBean selectByPrimaryKey(String questionId);

    int updateByPrimaryKeySelective(QuestionBean record);

    int updateByPrimaryKey(QuestionBean record);
}