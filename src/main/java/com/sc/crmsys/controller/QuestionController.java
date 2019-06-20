package com.sc.crmsys.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.fabric.xmlrpc.base.Data;
import com.sc.crmsys.bean.CustomerBean;
import com.sc.crmsys.bean.QuestionBean;
import com.sc.crmsys.service.QuestionService;

@Controller
@RequestMapping("/question")
public class QuestionController {
	
	@Resource
	private QuestionService questionService;
	
	@RequestMapping("/info")
	public String selectQuestions(Map map)
	{
		List<QuestionBean> question = questionService.selectQuestion();
		map.put("questionList", question);
		return "forward:/jsp/index.jsp";
	}

	
	@RequestMapping("/select")
	@ResponseBody
	public List<QuestionBean> selectOne(String content)
	{
		List<QuestionBean> questionone = questionService.selectOne(content);
		return questionone;
	}
	
	@RequestMapping("/add")
	public String add(Map map,QuestionBean question)
	{
		String questionId = UUID.randomUUID().toString();
		Date date = new Date();
		question.setQuestionId(questionId);
		question.setQuestionTime(date);
		questionService.addQuestion(question);
		return "forward:/jsp/index.jsp";
	}

}

