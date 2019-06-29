package com.sc.crmsys.service;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.CheckPointBean;
import com.sc.crmsys.mapper.CheckPointBeanMapper;

@Service("checkPointService")
public class CheckPointServiceImpl implements CheckPointService{

	@Resource
	private CheckPointBeanMapper checkPointBeanMapper;
	
	@Override
	public void insert(CheckPointBean checkPointBean) {
		checkPointBeanMapper.insert(checkPointBean);
	}

	@Override
	public PageInfo<CheckPointBean> selectAll(Integer pn, Integer size, String checkPointTarget) {
		PageHelper.startPage(pn, size);
		List<CheckPointBean> CheckPointBean = checkPointBeanMapper.selectAll(checkPointTarget);
		PageInfo<CheckPointBean> pageInfo = new PageInfo<CheckPointBean>(CheckPointBean);
		return pageInfo;
	}

	@Override
	public CheckPointBean selectByPrimaryKey(String checkPointId) {
		CheckPointBean checkPointBean = checkPointBeanMapper.selectByPrimaryKey(checkPointId);
		return checkPointBean;
	}

	@Override
	public void updateByPrimaryKeySelective(CheckPointBean checkPointBean) {
		checkPointBeanMapper.updateByPrimaryKeySelective(checkPointBean);
	}

	@Override
	public void deleteByPrimaryKey(String checkPointId) {
		checkPointBeanMapper.deleteByPrimaryKey(checkPointId);
	}

	@Override
	public List<CheckPointBean> selectAllCheckPoint() {
		List<CheckPointBean> CheckPointBean = checkPointBeanMapper.selectAllCheckPoint();
		return CheckPointBean;
	}
	
	
	
}
