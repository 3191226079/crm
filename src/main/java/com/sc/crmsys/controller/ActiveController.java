package com.sc.crmsys.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.ActiveBean;
import com.sc.crmsys.service.ActiveService;

@Controller
@RequestMapping("/active")
public class ActiveController {

	@Resource
	private ActiveService activeService;
	
	@RequiresPermissions("luolu:plan")
	@RequestMapping("/insertActive")
	public String insertActive(ActiveBean avtiveBean)
	{
		String token = UUID.randomUUID().toString();
		avtiveBean.setActiveUpdateTime(new Date());
		avtiveBean.setActiveId(token);
		activeService.insert(avtiveBean);
		return "redirect:selectActive";
	}
	
	@RequiresPermissions("luolu:plan")
	@RequestMapping("/selectActive")
	public String selectActive(@RequestParam(defaultValue="1")Integer pn,@RequestParam(defaultValue="5")Integer size,ActiveBean activeBean,Map<String, Object> data)
	{
			PageInfo<ActiveBean> activeBean1 = activeService.selectAll(pn,size,activeBean.getActiveTitle());
			data.put("title", activeBean.getActiveTitle());
			data.put("activeBean1", activeBean1);
			return "forward:/jsp/lookSchedule.jsp";
	}
	
	@RequiresPermissions("luolu:plan")
	@RequestMapping("/search")
	public String Search(ActiveBean activeBean,Map<String, Object> map)
	{
		List<ActiveBean> title = activeService.selectByTitle(activeBean.getActiveTitle());
		map.put("activeBean1", title);
		return "forward:/jsp/lookSchedule.jsp";
	}
	
	@RequiresPermissions("luolu:plan")
	@RequestMapping("/update")
	public String activeUpdate(ActiveBean activeBean)
	{
		activeBean.setActiveUpdateTime(new Date());
		activeService.updateByPrimaryKeySelective(activeBean);
		return "redirect:selectActive";
	}
	
	@RequiresPermissions("luolu:plan")
	@RequestMapping("/jumpToUpdate")
	public String jumpToUpdate(String activeId,Map<String, Object> map)
	{
		ActiveBean activeBean = activeService.selectByPrimaryKey(activeId);
		map.put("activeBean1", activeBean);
		return "forward:/jsp/activeUpdate.jsp";
	}
	
	@RequiresPermissions("luolu:plan")
	@RequestMapping("/deleteActive")
	public String deleteActive(String activeId)
	{
		activeService.deleteByPrimaryKey(activeId);
		return "redirect:selectActive";
	}
}
