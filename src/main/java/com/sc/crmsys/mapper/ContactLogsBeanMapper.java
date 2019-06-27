package com.sc.crmsys.mapper;

import java.util.List;

import com.sc.crmsys.bean.ContactLogsBean;

public interface ContactLogsBeanMapper {
    void deleteByPrimaryKey(String contactLogsId);

    void insert(ContactLogsBean record);

    int insertSelective(ContactLogsBean record);

    ContactLogsBean selectByPrimaryKey(String contactLogsId);

    void updateByPrimaryKeySelective(ContactLogsBean record);

    int updateByPrimaryKey(ContactLogsBean record);
    
    
    public List<ContactLogsBean> getcontactrecord();
}