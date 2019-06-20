package com.sc.crmsys.utils;

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
	
}
