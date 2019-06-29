package com.sc.crmsys.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.GetTimeBean;
import com.sc.crmsys.bean.SignBean;
import com.sc.crmsys.bean.SignCountBean;
import com.sc.crmsys.bean.UserBean;
import com.sc.crmsys.service.SignService;
import com.sc.crmsys.utils.MyUtils;

@Controller
@RequestMapping("/sign")
public class SignController {
	
	@Resource
	private SignService signService;

	/***
	 * 
	 * 得到所有用户的签到信息
	 * 返回List<SignBean>的数据集合到sign.jsp页面
	 */
	@RequiresPermissions("huguan:sign")
	@RequestMapping("/info")
	public String signInfo(Map map,SignBean sign)
	{
		Subject subject = SecurityUtils.getSubject();
		UserBean userBean = (UserBean)subject.getPrincipal();
		String userId = userBean.getUserId();
		//得到当前时间年 月月
        GetTimeBean times = MyUtils.getTime();//调用时间获取方法
		String signMonth = times.getMonth();//当前月
		String signYear = times.getYear();//当前年
		String day = times.getDay();//当前天数
        
		sign.setUserId(userId);
		sign.setSignYear(signYear);
		sign.setSignMonth(signMonth);
		//获取得到当前时间年、月的签到信息
		List<SignBean> signInfo = signService.signInfo(sign);
	    SignCountBean conutInfo = signService.getConutInfo(userId,signYear,signMonth);
	    String state ="1";
	    for (int i = 0; i < signInfo.size(); i++) {
	    	if(Integer.valueOf(day) == Integer.valueOf(signInfo.get(i).getSignDays()))
		    {
		    	state = "2";
		    }
	    	
		}
	    
		map.put("conutInfo", conutInfo);
		map.put("signInfo", signInfo);
		map.put("state", state);
		return "forward:/jsp/sign.jsp";
	}
	
	@RequiresPermissions("huguan:sign")
	@RequestMapping("/add")
	@ResponseBody
	public HashMap<String, Object> addSign(SignBean sign)
	{
		HashMap<String, Object> hashMap = new HashMap<>();
		String signId = UUID.randomUUID().toString();
		
		GetTimeBean times = MyUtils.getTime();//调用时间获取方法
		Date time = times.getTime();//当前时间
		String month = times.getMonth();//当前月
		String year = times.getYear();//当前年
		Date yesterday = times.getYesterday();//当前时间的前一天
		String day = times.getDay();//当前天
		
		Subject subject = SecurityUtils.getSubject();
		UserBean userBean = (UserBean)subject.getPrincipal();
		String userId = userBean.getUserId();
		
		sign.setSignDays(day);
		sign.setUserId(userId);
		sign.setSignMonth(month);
		sign.setSignYear(year);
		
		Integer empty = signService.getEmpty(sign);//查询当前时间是否已经签到
		if (empty == 0) {
			sign.setSignId(signId);
			sign.setSignTime(time);
			sign.setSignId(signId);
			signService.addSign(sign);
			SignCountBean conutInfo = signService.getConutInfo(userId,year,month);
			if(conutInfo == null)
			{
				SignCountBean signCountBean = new SignCountBean();
				signCountBean.setSignCountId(UUID.randomUUID().toString());
				signCountBean.setSignCounts("1");
				signCountBean.setSignCountTime(time);
				signCountBean.setSignMonth(month);
				signCountBean.setSignYear(year);
				signCountBean.setUserId(userId);
				signService.addSignCountInfo(signCountBean);
			}
			else
			{
				SignCountBean signCountBean = new SignCountBean();
				signCountBean.setSignCountId(conutInfo.getSignCountId());
				signCountBean.setSignCountTime(time);
				String signCounts = "1";
				if(Integer.valueOf(day) == conutInfo.getSignCountTime().getDate() + 1)
				{
					signCounts = (Integer.valueOf(conutInfo.getSignCounts())+1)+"";
				}
				signCountBean.setSignCounts(signCounts);
				signService.updateSignCount(signCountBean);
			}
		}
		else
		{
			hashMap.put("fail", "今日已签到！");
		}
		Integer signNum = signService.signNum(userId,year,month);
		String signCount = signService.signCount(userId,year,month);
		hashMap.put("signNum", signNum);
		hashMap.put("signCount",signCount);
		return hashMap;
	}
	
	

}
