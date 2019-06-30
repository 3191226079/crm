package com.sc.crmsys.interceptor;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sc.crmsys.bean.JournalBean;
import com.sc.crmsys.service.JournalService;

public class JournalInterceptor implements HandlerInterceptor{
	
	@Resource
	private JournalService journalService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
	        
	        JournalBean journalBean = new JournalBean();
	        journalBean.setVisitIp(request.getServletPath().substring(1,request.getServletPath().length() ));//得到请求地址，存入Bean
	        journalService.addJoural(journalBean);
	     
	      return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
