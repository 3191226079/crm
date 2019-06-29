package com.sc.crmsys.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sc.crmsys.bean.UserBean;
import com.sc.crmsys.mapper.CustomerBeanMapper;
@Component
public class TimeTaskCool {
	
	@Resource
	private CustomerBeanMapper customerBeanMapper;
	
	public void addcustomerlose() {
		
		
	
		
		ArrayList<String> list = customerBeanMapper.getcustomerid();
		List<String> getcustomerloseid = customerBeanMapper.getcustomerloseid();
		
		int b=0;
		for( int j=0;j<getcustomerloseid.size();j++)
		{
			for(int a=0;a<list.size();a++)
			{
				if(getcustomerloseid.get(j).equals(list.get(a)))
				{
				b++;	
				}
				
			}
			
		}
	
		System.out.println("qqqqqqqqqq");
		if(b<list.size())
		{
			
			int size = list.size();
			
			for (int i = 0; i < size;i++) {			
				String string1 = list.get(i);			
				
	
				new Thread(new Runnable() {
					@Override
					public void run() {			
						String token = UUID.randomUUID().toString();
						customerBeanMapper.add(string1, token);
					}
				}).start();
				 
			}
			b=0;
		}
		else 
		{
		b=0;
			
		
		}
		
	
	}
}
