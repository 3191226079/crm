package com.sc.crmsys.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.JournalBean;

public interface JournalService {
	
	public void  addJoural(JournalBean journal);	
	
	public  PageInfo<JournalBean> selectJournal(int pn,int size);
}
