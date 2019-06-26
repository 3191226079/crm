package com.sc.crmsys.service;

import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.SignBean;
import com.sc.crmsys.bean.SignCountBean;

public interface SignService {
	
	public void addSign(SignBean sign);
	
	public List<SignBean> signInfo(SignBean sign);
	
	public Integer signNum(String userId,String signYear,String signMonth);
	
	public String signCount(String userId,String year,String month);
	
	public SignBean getYerterDay(SignBean sign);
	
	public SignCountBean getConutInfo(String userId,String year,String month);

	public SignCountBean getYesCount(SignCountBean signCount);
	
	void addSignCountInfo(SignCountBean signCountBean);
	
	void updateSignCount (SignCountBean signCountBean);
	
	public Integer getEmpty(SignBean sign);
	
}
