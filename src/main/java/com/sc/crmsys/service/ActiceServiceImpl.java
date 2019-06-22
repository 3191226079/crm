package com.sc.crmsys.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.ActiveBean;
import com.sc.crmsys.mapper.ActiveBeanMapper;

@Service("activeService")
public class ActiceServiceImpl implements ActiveService{

	@Resource
	private ActiveBeanMapper activeBeanMapper;
	
	@Override
	public PageInfo<ActiveBean> selectAll(Integer pn,Integer size,String activeTitle) {
		PageHelper.startPage(pn, size);
		List<ActiveBean> activeBean = activeBeanMapper.selectAll(activeTitle);
		PageInfo<ActiveBean> pageInfo = new PageInfo<ActiveBean>(activeBean);
		return pageInfo;
	}

	@Override
	public void insert(ActiveBean active) {
		activeBeanMapper.insert(active);
	}

	@Override
	public List<ActiveBean> selectByTitle(String activeTilte) {
		List<ActiveBean> title = activeBeanMapper.selectByTitle(activeTilte);
		return title;
	}

	@Override
	public void updateByPrimaryKeySelective(ActiveBean activeBean) {
		activeBeanMapper.updateByPrimaryKeySelective(activeBean);
	}

	@Override
	public ActiveBean selectByPrimaryKey(String activeId) {
		ActiveBean activeBean = activeBeanMapper.selectByPrimaryKey(activeId);
		return activeBean;
	}

	@Override
	public void deleteByPrimaryKey(String activeId) {
		activeBeanMapper.deleteByPrimaryKey(activeId);
	}

	
}
