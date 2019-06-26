package com.sc.crmsys.bean;

import java.util.Date;

public class GetTimeBean {
	
	private String year;
	private String month;
	private String day;
	private Date time;
	private Date yesterday;
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public GetTimeBean() {
		super();
	}
	public Date getYesterday() {
		return yesterday;
	}
	public void setYesterday(Date yesterday) {
		this.yesterday = yesterday;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public GetTimeBean(String year, String month, String day, Date time, Date yesterday) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
		this.time = time;
		this.yesterday = yesterday;
	}
	
	
	

}
