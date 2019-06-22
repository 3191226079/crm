package com.sc.crmsys.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.crmsys.bean.SignBean;
import com.sc.crmsys.bean.UserBean;
import com.sc.crmsys.service.SignService;

@Controller
@RequestMapping("/sign")
public class SignController {
	
	@Resource
	private SignService signService;

	@RequestMapping("/info")
	public String signInfo(Map map)
	{
		Subject subject = SecurityUtils.getSubject();
		UserBean userBean = (UserBean)subject.getPrincipal();
		String userId = userBean.getUserId();
		List<SignBean> signInfo = signService.signInfo(userId);
		map.put("signInfo", signInfo);
		return "forward:/jsp/sign.jsp";
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public HashMap<String, Object> addSign(SignBean sign)
	{
		
		Date signTime = new Date();
		String signId = UUID.randomUUID().toString();
		String signDays = String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
		
		Subject subject = SecurityUtils.getSubject();
		UserBean userBean = (UserBean)subject.getPrincipal();
		String userId = userBean.getUserId();
		
		sign.setUserId(userId);
		sign.setSignDays(signDays);
		sign.setSignId(signId);
		sign.setSignTime(signTime);
		signService.addSign(sign);
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("result", "操作成功");
		return hashMap;
	}
	
	

}
