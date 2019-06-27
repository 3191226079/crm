package com.sc.crmsys.mapper;

import java.util.List;

import com.sc.crmsys.bean.ContactsBean;

public interface ContactsBeanMapper {
    int deleteByPrimaryKey(String contactsId);

    void insert(ContactsBean record);

    int insertSelective(ContactsBean record);

    ContactsBean selectByPrimaryKey(String contactsId);

    void updateByPrimaryKeySelective(ContactsBean record);

    int updateByPrimaryKey(ContactsBean record);
    

    public List<ContactsBean> getcontacts(); 
    
    
    public List<ContactsBean> check(String customerId);
}