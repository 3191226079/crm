package com.sc.crmsys.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.SignBean;

public interface SignService {
	
	public void addSign(SignBean sign);
	
	public List<SignBean> signInfo(String userId);
	
	public Integer signNum(String userId);
}
