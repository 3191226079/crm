package com.sc.crmsys.mapper;

import java.util.List;

import com.sc.crmsys.bean.ContactLogsBean;

public interface ContactLogsBeanMapper {
    int deleteByPrimaryKey(String contactLogsId);

    int insert(ContactLogsBean record);

    int insertSelective(ContactLogsBean record);

    ContactLogsBean selectByPrimaryKey(String contactLogsId);

    int updateByPrimaryKeySelective(ContactLogsBean record);

    int updateByPrimaryKey(ContactLogsBean record);
    
    public List<ContactLogsBean> getcontactrecord();
}