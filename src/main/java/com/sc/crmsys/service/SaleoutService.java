package com.sc.crmsys.service;

import java.util.List;

import com.sc.crmsys.bean.CustomerBean;
import com.sc.crmsys.bean.SaleOutBean;

public interface SaleoutService {
	public List<SaleOutBean> getsaleout();
	public void addsaleout(SaleOutBean saleOutBean);
	public SaleOutBean get1ssaleout(String saleoutId);
	
	public void updatesaleout(SaleOutBean saleOutBean);
	
	public void delsaleout(String saleoutId);
	
	//查销售单编号
	public List<SaleOutBean>  getSaleOutId();
	
	public List<SaleOutBean>  selectSaleOutId();

}
