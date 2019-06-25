package com.sc.crmsys.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

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

}
