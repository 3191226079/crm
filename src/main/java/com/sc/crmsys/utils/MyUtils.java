package com.sc.crmsys.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.shiro.crypto.hash.Md5Hash;

public class MyUtils {
	public static String md5(String pass,String salt,int hashIterations)
	{
		Md5Hash md5Hash = new Md5Hash(pass, salt, hashIterations);
		return md5Hash.toString();
	}
	
	public static boolean isEmpty(String str)
	{
		if(str == null)
		{
			return true;
		}
		else if(str.trim().equals(""))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static String getStringByLength(Integer length)
	{
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			char charAt = base.charAt(number);
			stringBuffer.append(charAt);
		}
		return stringBuffer.toString();
	}
	
	public static String getSalt()
	{
		return getStringByLength(6);
	}
	
	
	
	public static Date setearly()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		
		
		Date time = calendar.getTime();
				
		return time;
	}
	
	public static Date setlater()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		
		
		Date time = calendar.getTime();
				
		return time;
	}
	

	public static Date setthreeearly()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(calendar.DAY_OF_MONTH)-3);
		Date time = calendar.getTime();
		
		return time;
	}
	
	
	public static Date setthreelater()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY,23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(calendar.DAY_OF_MONTH)-3);
		Date time = calendar.getTime();
		
		return time;
	}
	
	public static Date setsevenearly()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(calendar.DAY_OF_MONTH)-7);
		Date time = calendar.getTime();
		
		return time;
	}
	public static Date setsevenlater()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY,23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(calendar.DAY_OF_MONTH)-7);
		Date time = calendar.getTime();
		
		return time;
	}
	
	public static Date setonemonthearly()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.add(Calendar.MONTH,-1);
		Date time = calendar.getTime();
		
		
		return time;
	}
	
}
