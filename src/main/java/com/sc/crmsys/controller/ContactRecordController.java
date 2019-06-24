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
	

}
