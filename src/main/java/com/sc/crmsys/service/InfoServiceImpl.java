package com.sc.crmsys.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
	public PageInfo<InfoDetailBean> selectAll(Integer pn,Integer size,InfoDetailBean infoDetailBean) {
		PageHelper.startPage(pn, size);
		List<InfoDetailBean> InfoDetailBean = infoDetailBeanMapper.selectAll(infoDetailBean);
		PageInfo<InfoDetailBean> pageInfo = new PageInfo<InfoDetailBean>(InfoDetailBean);
		return pageInfo;
	}

	@Override
	public void insert(InfoDetailBean infoDetailBean,InfoBean infoBean) {
		infoBeanMapper.insert(infoBean);
		infoDetailBeanMapper.insert(infoDetailBean);
	}

	@Override
	public void deleteByinfoDetailId(String infoDetailId) 
	{
		infoDetailBeanMapper.deleteByinfoDetailId(infoDetailId);
	}

	@Override
	public void deleteByinfoId(String infoId) {
		infoBeanMapper.deleteByinfoId(infoId);
	}

}
