package com.sc.crmsys.service;

import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.InfoBean;
import com.sc.crmsys.bean.InfoDetailBean;

public interface InfoService {

	public PageInfo<InfoDetailBean> selectAll(Integer pn,Integer size,InfoDetailBean infoDetailBean);
	
	public void insert(InfoDetailBean infoDetailBean,InfoBean infoBean);
	
	public void deleteByinfoDetailId(String infoDetailId,String infoId);
	
}
