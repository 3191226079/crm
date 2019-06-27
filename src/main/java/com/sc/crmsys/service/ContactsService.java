package com.sc.crmsys.service;



import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.ContactsBean;


public interface ContactsService {
	
	public PageInfo<ContactsBean> selectAll(Integer pn,Integer size,ContactsBean contactsBean);
	
	public void add(ContactsBean contactsBean);
	
	public ContactsBean get1(String contactsId);
	
	
	public void update(ContactsBean contactsBean);
	
	
	public PageInfo<ContactsBean> check(Integer pn,Integer size,String customerId);
	
	/*public List<ContactsBean> check(String customerId);*/
}
