package com.sc.crmsys.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.QuestionBean;
import com.sc.crmsys.mapper.QuestionBeanMapper;


@Service
public class QuestionServiceImpl implements QuestionService{

	@Resource
	private QuestionBeanMapper questionMapper;


	@Override
	public PageInfo<QuestionBean> selectOne(String content,String state,int pn,int size) {
		PageHelper.startPage(pn, size);
		List<QuestionBean> selectOne = questionMapper.selectOne(content, state);
		PageInfo<QuestionBean> pageInfo = new PageInfo<>(selectOne);
		return pageInfo;
	}
	
	@Override
	public void addQuestion(QuestionBean question) {
		 questionMapper.insertSelective(question);
	}

	@Override
	public void addAnswer(QuestionBean question) {
		questionMapper.updateByPrimaryKeySelective(question);
	}

}
