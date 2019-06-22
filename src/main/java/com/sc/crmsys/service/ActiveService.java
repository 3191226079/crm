package com.sc.crmsys.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.ActiveBean;

public interface ActiveService {

	public PageInfo<ActiveBean> selectAll(Integer pn,Integer size,String activeTitle);
	
	public void insert(ActiveBean active);
	
	public List<ActiveBean> selectByTitle(String activeTilte);
	
	public void updateByPrimaryKeySelective(ActiveBean activeBean);
	
	public ActiveBean selectByPrimaryKey(String activeId);
	
	public void deleteByPrimaryKey(String activeId);
}
