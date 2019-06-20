package com.sc.crmsys.mapper;

import com.sc.crmsys.bean.AnswerBean;

public interface AnswerBeanMapper {
    int deleteByPrimaryKey(String answerId);

    int insert(AnswerBean record);

    int insertSelective(AnswerBean record);

    AnswerBean selectByPrimaryKey(String answerId);

    int updateByPrimaryKeySelective(AnswerBean record);

    int updateByPrimaryKey(AnswerBean record);
}