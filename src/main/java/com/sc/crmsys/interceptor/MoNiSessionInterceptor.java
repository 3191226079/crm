package com.sc.crmsys.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sc.crmsys.bean.UserBean;
import com.sc.crmsys.config.Config;




public class MoNiSessionInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		
		if(Config.DEVELOPMENT)
		{
			UserBean userBean = new UserBean();
			userBean.setCompanyId("1");
			userBean.setUserName("张三");
			arg0.getSession().setAttribute(Config.LOGIN,"userBean");
			
			
		}
		return true;
	}

}
