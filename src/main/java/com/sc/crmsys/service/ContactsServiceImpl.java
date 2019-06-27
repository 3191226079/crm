package com.sc.crmsys.service;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.ContactsBean;
import com.sc.crmsys.mapper.ContactsBeanMapper;


@Service("contactsService")
public class ContactsServiceImpl implements ContactsService{
	
	@Resource
	private ContactsBeanMapper contactsBeanMapper;
	

	@Override
	public PageInfo<ContactsBean> selectAll(Integer pn, Integer size, ContactsBean contactsBean) {
		PageHelper.startPage(pn, size);
		List<ContactsBean> getcontacts = contactsBeanMapper.getcontacts();
		PageInfo<ContactsBean> pageInfo = new PageInfo<ContactsBean>(getcontacts);
		return pageInfo;
	}


	@Override
	public void add(ContactsBean contactsBean) {
		String token = UUID.randomUUID().toString();
		contactsBean.setContactsId(token);
		contactsBeanMapper.insert(contactsBean);
		
	}


	@Override
	public ContactsBean get1(String contactsId) {
		ContactsBean selectByPrimaryKey = contactsBeanMapper.selectByPrimaryKey(contactsId);
		return selectByPrimaryKey;
	}


	@Override
	public void update(ContactsBean contactsBean) {
		contactsBeanMapper.updateByPrimaryKeySelective(contactsBean);
		
	}


	@Override
	public PageInfo<ContactsBean> check(Integer pn, Integer size, String customerId) {
		PageHelper.startPage(pn, size);
		List<ContactsBean> check = contactsBeanMapper.check(customerId);
		PageInfo<ContactsBean> pageInfo = new PageInfo<ContactsBean>(check);
		return pageInfo;
	}


/*	@Override
	public List<ContactsBean> check(String customerId) {
		List<ContactsBean> check = contactsBeanMapper.check(customerId);
		
		return check;
	}*/

}
