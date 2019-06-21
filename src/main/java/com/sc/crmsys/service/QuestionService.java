package com.sc.crmsys.service;

import java.util.List;
import com.sc.crmsys.bean.CustomerBean;
import com.sc.crmsys.bean.QuestionBean;

public interface QuestionService {

	public List<QuestionBean> selectOne(String content);
	public void addQuestion(QuestionBean question);

}
