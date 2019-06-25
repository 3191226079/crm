package com.sc.crmsys.service;

import java.util.List;

import com.sc.crmsys.bean.SaleInfoBean;

public interface SaleinfoService {

	
	public List<SaleInfoBean> getsaleinfo();
	public void addsaleinfo( SaleInfoBean saleInfoBean);
	
	public SaleInfoBean get1saleinfo(String saleinfoId);
	
	public void updatesaleinfo(SaleInfoBean saleInfoBean);
	
	public void delsaleinfo(String saleinfoId);
}
