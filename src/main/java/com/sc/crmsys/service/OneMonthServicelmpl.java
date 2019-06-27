package com.sc.crmsys.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.crmsys.bean.CustomerBean;
import com.sc.crmsys.mapper.CustomerBeanMapper;
import com.sc.crmsys.utils.MyUtils;

@Service("onemonth")
public class OneMonthServicelmpl implements OneMonthService{

	@Resource
	private CustomerBeanMapper customerBeanMapper;
	
	@Override
	public List<CustomerBean> getonemonth() {
		Date setonemonthearly = MyUtils.setonemonthearly();
		Date setlater = MyUtils.setlater();
		List<CustomerBean> selectonemonth = customerBeanMapper.selectonemonth(setonemonthearly, setlater);
		return selectonemonth;
	}

	@Override
	public void delom(String customerId) {
		customerBeanMapper.deleteByPrimaryKey(customerId);
		
	}

	@Override
	public PageInfo<CustomerBean> selectAll(Integer pn, Integer size, CustomerBean customerBean) {
		PageHelper.startPage(pn, size);
       Date setearly = MyUtils.setearly();
		Date setlater = MyUtils.setlater();
		Date setonemonthearly = MyUtils.setonemonthearly();
		List<CustomerBean> CustomerBean = customerBeanMapper.selectToday(setonemonthearly, setlater);
		PageInfo<CustomerBean> pageInfo = new PageInfo<CustomerBean>(CustomerBean);
		return pageInfo;
	}
	

}
