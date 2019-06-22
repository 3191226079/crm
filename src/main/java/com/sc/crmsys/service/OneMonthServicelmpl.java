package com.sc.crmsys.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

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
	

}
