package com.sc.crmsys.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtils {
	public static String getDate(Date time)
	{
		if(time!=null)
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String Ntime = sdf.format(time);
			return Ntime;
		}
		else
		{
			return null;
		}
	}

}
