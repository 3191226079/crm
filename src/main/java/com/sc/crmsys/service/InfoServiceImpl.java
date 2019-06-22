package com.sc.crmsys.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sc.crmsys.bean.InfoBean;
import com.sc.crmsys.bean.InfoDetailBean;
import com.sc.crmsys.mapper.InfoBeanMapper;
import com.sc.crmsys.mapper.InfoDetailBeanMapper;

@Service("infoService")
public class InfoServiceImpl implements InfoService{

	@Resource
	private InfoDetailBeanMapper infoDetailBeanMapper;
	@Resource
	private InfoBeanMapper infoBeanMapper;
	
	@Override
	public List<InfoDetailBean> selectAll(InfoDetailBean infoDetailBean) {
		List<InfoDetailBean> InfoDetailBean = infoDetailBeanMapper.selectAll(infoDetailBean);
		return InfoDetailBean;
	}

	@Override
	public void insert(InfoDetailBean infoDetailBean) {
		infoDetailBeanMapper.insert(infoDetailBean);
	}

	@Override
	public void insert(InfoBean infoBean) {
		infoBeanMapper.insert(infoBean);
	}

}
