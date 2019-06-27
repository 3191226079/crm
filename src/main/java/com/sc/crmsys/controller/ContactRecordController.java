package com.sc.crmsys.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sc.crmsys.bean.ContactLogsBean;
import com.sc.crmsys.service.ContactRecordService;

@Controller
@RequestMapping("/getcontactrecord")
public class ContactRecordController
{
	@Resource
	private ContactRecordService contactRecordService;

	@RequestMapping("/get")
	public String getcontactrecord(Map<String, Object> map)
	{
		List<ContactLogsBean> getcontactrecord = contactRecordService.getcontactrecord();
		map.put("getcontactrecord", getcontactrecord);
		
		
		return "forward:/jsp/contactrecord.jsp";
	}
	
	
	
	@RequestMapping("/add")
	public String addcontactrecord(ContactLogsBean contactLogsBean)
	{
		contactRecordService.addcontactrecord(contactLogsBean);
	
		return "redirect:get";
	}
	
	
	@RequestMapping("/get1")
	public String get1contactrecord(String contactLogsId,Map<String, Object> map)
	{
		ContactLogsBean record = contactRecordService.get1contactrecord(contactLogsId);
		map.put("record", record);
	  return "forward:/jsp/get1contactrecord.jsp";
		
	}
	
	@RequestMapping("/update")
	public String updatecontactrecord(ContactLogsBean contactLogsBean)
	{
		contactRecordService.update(contactLogsBean);
		return "redirect:get";
	}
	
	
	@RequestMapping("/del")
	public String delcontactrecord(String contactLogsId)
	{
		contactRecordService.delcontactrecord(contactLogsId);
		return "redirect:get";
	}

}
