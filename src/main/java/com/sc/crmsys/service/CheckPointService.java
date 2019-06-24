package com.sc.crmsys.service;

import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.CheckPointBean;

public interface CheckPointService {

	public void insert(CheckPointBean checkPointBean);
	
	public PageInfo<CheckPointBean> selectAll(Integer pn,Integer size,String checkPointTarget);

	public CheckPointBean selectByPrimaryKey(String checkPointId);
	
	public void updateByPrimaryKeySelective(CheckPointBean checkPointBean);
	
	public void deleteByPrimaryKey(String checkPointId);
}
