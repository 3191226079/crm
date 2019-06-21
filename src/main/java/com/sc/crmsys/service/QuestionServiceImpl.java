package com.sc.crmsys.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sc.crmsys.bean.CustomerBean;
import com.sc.crmsys.bean.QuestionBean;
import com.sc.crmsys.mapper.QuestionBeanMapper;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Resource
	private QuestionBeanMapper questionMapper;


	@Override
	public List<QuestionBean> selectOne(String content) {
		List<QuestionBean> question = questionMapper.selectOne(content);
		return question;
	}

	@Override
	public void addQuestion(QuestionBean question) {
		 questionMapper.insertSelective(question);
	}

}
