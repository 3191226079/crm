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

@Service("threedayservice")
public class ThreeDayServicelmpl implements ThreeDayService{

	@Resource
	private CustomerBeanMapper customerBeanMapper;
	
	@Override
	public List<CustomerBean> getthreeday() {
		Date setthreeearly = MyUtils.setthreeearly();
		Date setthreelater = MyUtils.setthreelater();
		Date setlater = MyUtils.setlater();
		List<CustomerBean> selectthree = customerBeanMapper.selectthree(setthreeearly, setlater);	
		return selectthree;
	}

	@Override
	public void delthreeday(String customerId) {
		customerBeanMapper.deleteByPrimaryKey(customerId);
		
	}

	@Override
	public PageInfo<CustomerBean> selectAll(Integer pn, Integer size, CustomerBean customerBean) {
		PageHelper.startPage(pn, size);
       Date setearly = MyUtils.setearly();
		Date setlater = MyUtils.setlater();
		Date setthreeearly = MyUtils.setthreeearly();
		Date setthreelater = MyUtils.setthreelater();
		List<CustomerBean> CustomerBean = customerBeanMapper.selectToday(setthreeearly, setlater);
		PageInfo<CustomerBean> pageInfo = new PageInfo<CustomerBean>(CustomerBean);
		return pageInfo;
	}

}
