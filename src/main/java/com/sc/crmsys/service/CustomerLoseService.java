package com.sc.crmsys.service;

import java.util.List;

import com.sc.crmsys.bean.CustomerLoseBean;

public interface CustomerLoseService {
	public List<CustomerLoseBean> getcustomerlose();
	
	public CustomerLoseBean selectcustomerlose(String customerLoseId);
	
	public void updatecustomerlose(CustomerLoseBean customerLoseBean);
	
	public List<CustomerLoseBean> confirmationofloss();
	
	public List<CustomerLoseBean> getSelectCustomerlose();
	


}
