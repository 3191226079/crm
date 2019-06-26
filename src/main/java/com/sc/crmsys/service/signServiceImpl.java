package com.sc.crmsys.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.QuestionBean;
import com.sc.crmsys.bean.SignBean;
import com.sc.crmsys.bean.SignCountBean;
import com.sc.crmsys.mapper.SignBeanMapper;
import com.sc.crmsys.mapper.SignCountBeanMapper;

@Service
public class signServiceImpl implements SignService{

	@Resource
	private SignBeanMapper signMapper;
	
	@Resource
	private SignCountBeanMapper signCountMapper;
	
	@Override
	public void addSign(SignBean sign) {
		signMapper.insertSelective(sign);
		
	}

	@Override
	public List<SignBean> signInfo(SignBean sign) {
		List<SignBean> signInfo = signMapper.selectSignInfo(sign);
		return signInfo;
	}
	

	@Override
	public Integer signNum(String userId,String signYear,String signMonth) {
		Integer signNum = signMapper.signNum(userId,signYear,signMonth);
		return signNum;
	}

	@Override
	public SignBean getYerterDay(SignBean sign) {
		SignBean yerterDay = signMapper.getYerterDay(sign);
		return yerterDay;
	}

	@Override
	public String signCount(String userId,String year,String month) {
		String signCount = signCountMapper.signCount(userId,year,month);
		return signCount;
	}

	@Override
	public SignCountBean getConutInfo(String userId,String year,String month) {
		SignCountBean yesCount = signCountMapper.getConutInfo(userId,year,month);
		return yesCount;
	}
	@Override
	public SignCountBean getYesCount(SignCountBean signCount) {
		SignCountBean yesCount = signCountMapper.getYesCount(signCount);
		return yesCount;
	}
	
	@Override
	public void addSignCountInfo(SignCountBean signCountBean) {
		signCountMapper.insertSelective(signCountBean);
	}

	@Override
	public void updateSignCount(SignCountBean signCountBean) {
		signCountMapper.updateByPrimaryKeySelective(signCountBean);
	}

	@Override
	public Integer getEmpty(SignBean sign) {
		Integer empty = signMapper.getEmpty(sign);
		return empty;
	}

	
	
}
