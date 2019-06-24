package com.sc.crmsys.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sc.crmsys.bean.SignBean;
import com.sc.crmsys.mapper.SignBeanMapper;

@Service
public class signServiceImpl implements SignService{

	@Resource
	private SignBeanMapper signMapper;
	
	@Override
	public void addSign(SignBean sign) {
		signMapper.insertSelective(sign);
		
	}

	@Override
	public List<SignBean> signInfo(String userId) {
		List<SignBean> signInfo = signMapper.selectSignInfo(userId);
		return signInfo;
	}
	

	@Override
	public Integer signNum(String userId) {
		Integer signNum = signMapper.signNum(userId);
		return signNum;
	}
	
	
}
