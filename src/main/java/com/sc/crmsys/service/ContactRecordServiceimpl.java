package com.sc.crmsys.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

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

}
