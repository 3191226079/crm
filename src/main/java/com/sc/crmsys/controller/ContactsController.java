package com.sc.crmsys.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.ContactsBean;
import com.sc.crmsys.bean.CustomerLoseBean;
import com.sc.crmsys.bean.UserBean;
import com.sc.crmsys.service.ContactsService;

@Controller
@RequestMapping("/contacts")
public class ContactsController {
	
	@Resource
	private ContactsService contactsService;
	

	@RequestMapping("/get")
	public String selectInfo1(@RequestParam(defaultValue="1")Integer pn,@RequestParam(defaultValue="5")Integer size,ContactsBean contactsBean,Map<String, Object> map)
	{
		if(contactsBean == null)
		{
			contactsBean = new ContactsBean();
		}
		
		 PageInfo<ContactsBean> selectAll = contactsService.selectAll(pn, size, contactsBean);
		 map.put("selectAll", selectAll);
		 return "forward:/jsp/contacts.jsp";
	}
	
	@RequestMapping("/add1")
	public String add(ContactsBean contactsBean)
	{
		contactsService.add(contactsBean);
		return "redirect:get";
	}
	
	@RequestMapping("/get1")
	public String get1(String contactsId,Map<String, Object> map)
	{
		ContactsBean get1 = contactsService.get1(contactsId);
		map.put("get1", get1);
		return "forward:/jsp/get1contacts.jsp";
	}
	
	@RequestMapping("/update")
	public String update(ContactsBean contactsBean)
	{
		contactsService.update(contactsBean);
		return "redirect:get";
	}
	
	@RequestMapping("/addzhuan")
	public String addcontacts1(String customerId,Map<String, Object> map)
	{
		ContactsBean contactsBean = new ContactsBean();
		contactsBean.setCustomerId(customerId);
		
		
		
		Subject subject = SecurityUtils.getSubject();
		UserBean userBean = (UserBean)subject.getPrincipal();
		contactsBean.setCompanyId(userBean.getUserId());
		
		map.put("contactsBean", contactsBean);
		return "forward:/jsp/addcontacts.jsp";
	}

	
/*	@RequestMapping("/check")
	public String check(String customerId,Map<String, Object> map)
	{
		
		System.out.println("aaaaaaaaaaaa");
		List<ContactsBean> selectAll = contactsService.check(customerId);

		map.put("selectAll", selectAll);
		return "forward:/jsp/checkcontacts.jsp";
	}
	*/
	@RequestMapping("/check")
	public String check(@RequestParam(defaultValue="1")Integer pn,@RequestParam(defaultValue="5")Integer size,ContactsBean contactsBean,Map<String, Object> map)
	{
		if(contactsBean == null)
		{
			contactsBean = new ContactsBean();
		}
		String customerId = contactsBean.getCustomerId();
		
		 PageInfo<ContactsBean> selectAll = contactsService.check(pn, size, customerId);
				 
		 map.put("selectAll", selectAll);
		 return "forward:/jsp/checkcontacts.jsp";
	}
}
