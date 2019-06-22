package com.sc.crmsys.service;

import com.sc.crmsys.bean.UserBean;

public interface UserService {
	UserBean selectByUserName(String userName);
	UserBean selectByPrimaryKey(String userId);
	int updateByPrimaryKeySelective(UserBean userBean);
}
