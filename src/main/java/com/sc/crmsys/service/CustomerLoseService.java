package com.sc.crmsys.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.CustomerBean;
import com.sc.crmsys.bean.CustomerLoseBean;

public interface CustomerLoseService {
	public List<CustomerLoseBean> getcustomerlose();
	
	public CustomerLoseBean selectcustomerlose(String customerLoseId);
	
	public void updatecustomerlose(CustomerLoseBean customerLoseBean);
	
	public List<CustomerLoseBean> confirmationofloss(); 
	
	public void del(String customerLoseId);
	
	public PageInfo<CustomerLoseBean> selectAll(Integer pn,Integer size,CustomerLoseBean customerLoseBean);

	public PageInfo<CustomerLoseBean> selectAll1(Integer pn,Integer size,CustomerLoseBean customerLoseBean);
	

}
