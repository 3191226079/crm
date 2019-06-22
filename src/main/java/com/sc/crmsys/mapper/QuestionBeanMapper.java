package com.sc.crmsys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sc.crmsys.bean.QuestionBean;

public interface QuestionBeanMapper {
    int deleteByPrimaryKey(String questionId);

    int insert(QuestionBean record);

    int insertSelective(QuestionBean record);

    QuestionBean selectByPrimaryKey(String questionId);

    int updateByPrimaryKeySelective(QuestionBean record);

    int updateByPrimaryKey(QuestionBean record);
    
    List<QuestionBean> selectOne(@Param("content")String content,@Param("state")String state);
}