package com.sc.crmsys.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
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
	public String selectQuestions(Map map,String content,@RequestParam(defaultValue="1")int pn,@RequestParam(defaultValue="5")int size)
	{
		String state = "1";
		PageInfo<QuestionBean> question = questionService.selectOne(content, state, pn, size);
		map.put("questionList", question);
		return "forward:/jsp/index.jsp";
	}


	@RequestMapping("/add")
	public String add(QuestionBean question)
	{
		System.out.println(question.getQuestionContent());
		String questionId = UUID.randomUUID().toString();
		Date date = new Date();
		question.setQuestionId(questionId);
		question.setQuestionTime(date);
		questionService.addQuestion(question);
		return "forward:/question/info";
	}
	
	@RequestMapping("/answer")
	public String answerInfo(Map map,String content,String state,@RequestParam(defaultValue="1")int pn,@RequestParam(defaultValue="5")int size)
	{
		PageInfo<QuestionBean> question = questionService.selectOne(content, state, pn, size);
		map.put("questionList", question);
		return "forward:/jsp/answer.jsp";
	}
	
	@RequestMapping("/addanswer")
	@ResponseBody
	public HashMap<String, Object>  addAnswer(QuestionBean question)
	{
		String state = "1";
		Date date = new Date();
		question.setAnswerTime(date);
		question.setQuestionState(state);
		questionService.addAnswer(question);
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("result", "操作成功");
		return hashMap;
	}


}

