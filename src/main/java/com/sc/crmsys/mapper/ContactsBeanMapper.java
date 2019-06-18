package com.sc.crmsys.mapper;

import com.sc.crmsys.bean.ContactsBean;

public interface ContactsBeanMapper {
    int deleteByPrimaryKey(String contactsId);

    int insert(ContactsBean record);

    int insertSelective(ContactsBean record);

    ContactsBean selectByPrimaryKey(String contactsId);

    int updateByPrimaryKeySelective(ContactsBean record);

    int updateByPrimaryKey(ContactsBean record);
}