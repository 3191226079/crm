package com.sc.crmsys.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.ContactLogsBean;

import com.sc.crmsys.mapper.ContactLogsBeanMapper;

@Service("/contactRecordService")
public class ContactRecordServiceimpl  implements ContactRecordService{

	
	@Resource
	private  ContactLogsBeanMapper contactLogsBeanMapper;
	
	@Override
	public List<ContactLogsBean> getcontactrecord() {
		
		
		List<ContactLogsBean> getcontactrecord = contactLogsBeanMapper.getcontactrecord();
		
		return getcontactrecord;
	}

	@Override
	public void addcontactrecord(ContactLogsBean contactLogsBean) {
		contactLogsBeanMapper.insert(contactLogsBean);
	}

	@Override
	public ContactLogsBean get1contactrecord(String contactLogsId) {
		ContactLogsBean selectByPrimaryKey = contactLogsBeanMapper.selectByPrimaryKey(contactLogsId);
		return selectByPrimaryKey;
	}

	@Override
	public void update(ContactLogsBean contactLogsBean) {
		contactLogsBeanMapper.updateByPrimaryKeySelective(contactLogsBean);
		
	}

	@Override
	public void delcontactrecord(String contactLogsId) {
		
		contactLogsBeanMapper.deleteByPrimaryKey(contactLogsId);
	}

	@Override
	public PageInfo<ContactLogsBean> selectAll(Integer pn, Integer size, ContactLogsBean contactLogsBean) {
	PageHelper.startPage(pn, size);
	List<ContactLogsBean> getcontactrecord = contactLogsBeanMapper.getcontactrecord();
	PageInfo<ContactLogsBean> pageInfo = new PageInfo<ContactLogsBean>(getcontactrecord);
		return pageInfo;
	}

}
