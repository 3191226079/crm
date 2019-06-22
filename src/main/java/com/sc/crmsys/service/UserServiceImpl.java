package com.sc.crmsys.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sc.crmsys.bean.UserBean;
import com.sc.crmsys.mapper.UserBeanMapper;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService{

	@Resource 
	private UserBeanMapper userBeanMapper;
	
	@Override
	public UserBean selectByUserName(String userName) {
		UserBean userBean = userBeanMapper.selectByUserName(userName);
		return userBean;
	}

	@Override
	public UserBean selectByPrimaryKey(String userId) {
		UserBean userBean = userBeanMapper.selectByPrimaryKey(userId);
		return userBean;
	}

	@Override
	public int updateByPrimaryKeySelective(UserBean userBean) {
		userBeanMapper.updateByPrimaryKeySelective(userBean);
		return 0;
	}

	
}
