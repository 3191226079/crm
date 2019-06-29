package com.sc.crmsys.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.ContactLogsBean;
import com.sc.crmsys.bean.CustomerBean;


public interface ContactRecordService {
	public List<ContactLogsBean> getcontactrecord();
	
	
	public void addcontactrecord(ContactLogsBean contactLogsBean);
	
	
	public ContactLogsBean get1contactrecord(String contactLogsId);
	
	
	public void update(ContactLogsBean contactLogsBean);
	
	public void delcontactrecord(String contactLogsId);
	
	public PageInfo<ContactLogsBean> selectAll(Integer pn,Integer size,ContactLogsBean contactLogsBean);

}
