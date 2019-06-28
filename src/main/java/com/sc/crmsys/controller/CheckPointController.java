package com.sc.crmsys.controller;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.CheckPointBean;
import com.sc.crmsys.service.CheckPointService;

@Controller
@RequestMapping("/checkPoint")
public class CheckPointController {

	@Resource
	private CheckPointService checkPointService;
	
	@RequestMapping("/insertTask")
	public String insertTask(CheckPointBean checkPointBean)
	{
		String token = UUID.randomUUID().toString();
		checkPointBean.setCheckPointUpdateTime(new Date());
		checkPointBean.setCheckPointId(token);
		checkPointService.insert(checkPointBean);
		return "redirect:selectCheckPoint";
	}
	
	@RequestMapping("/selectCheckPoint")
	public String selectCheckPoint(@RequestParam(defaultValue="1")Integer pn, @RequestParam(defaultValue="5")Integer size,String checkPointTarget,Map<String, Object> map)
	{
		PageInfo<CheckPointBean> CheckPointBean = checkPointService.selectAll(pn, size, checkPointTarget);
		map.put("selectAllList", CheckPointBean);
		return "forward:/jsp/checkPointLook.jsp";
	}

	
	@RequestMapping("/jumpToUpdate")
	public String jumpToUpdate(String checkPointId,Map<String, Object> map)
	{
		CheckPointBean checkPointBean = checkPointService.selectByPrimaryKey(checkPointId);
		map.put("checkPointBean", checkPointBean);
		return "forward:/jsp/checkPointUpdate.jsp";
	}
	
	@RequestMapping("/update")
	public String updateCheckPoint(CheckPointBean checkPointBean)
	{
		checkPointBean.setCheckPointUpdateTime(new Date());
		checkPointService.updateByPrimaryKeySelective(checkPointBean);
		return "redirect:selectCheckPoint";
	}
	
	@RequestMapping("/delete")
	public String deleteCheckPoint(String checkPointId)
	{
		checkPointService.deleteByPrimaryKey(checkPointId);
		return "redirect:selectCheckPoint";
	}
}
