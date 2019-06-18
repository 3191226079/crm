package com.sc.crmsys.mapper;

import com.sc.crmsys.bean.JournalBean;

public interface JournalBeanMapper {
    int deleteByPrimaryKey(String journalNumber);

    int insert(JournalBean record);

    int insertSelective(JournalBean record);

    JournalBean selectByPrimaryKey(String journalNumber);

    int updateByPrimaryKeySelective(JournalBean record);

    int updateByPrimaryKey(JournalBean record);
}