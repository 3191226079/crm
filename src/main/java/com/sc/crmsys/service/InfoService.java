package com.sc.crmsys.service;

import java.util.List;

import com.sc.crmsys.bean.InfoBean;
import com.sc.crmsys.bean.InfoDetailBean;

public interface InfoService {

	public List<InfoDetailBean> selectAll(InfoDetailBean infoDetailBean);
	
	public void insert(InfoDetailBean infoDetailBean);
	
	public void insert(InfoBean infoBean);
}
