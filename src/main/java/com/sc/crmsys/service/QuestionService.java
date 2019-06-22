package com.sc.crmsys.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.CustomerBean;
import com.sc.crmsys.bean.QuestionBean;

public interface QuestionService {

	PageInfo<QuestionBean> selectOne(String content,String state,int pn,int size);
	public void addQuestion(QuestionBean question);
	public void addAnswer(QuestionBean question);

}
