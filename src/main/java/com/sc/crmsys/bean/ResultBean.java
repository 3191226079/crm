package com.sc.crmsys.bean;

public class ResultBean<T> {

	private String msg;
	private int state;
	private T data;
	
	//成功状态
	public static final int SUCCESS = 200;
	//失败状态
	public static final int ERROR = 400;
	
	/**
	 * 默认成功
	 */
	public ResultBean() {
		this(SUCCESS);
	}
	/**
	 * 传入状态
	 * @param state
	 */
	public ResultBean(int state) {
		super();
		this.state = state;
	}
	
	/**
	 * 传入状态及信息
	 * @param msg
	 * @param state
	 */
	public ResultBean(String msg, int state) {
		super();
		this.msg = msg;
		this.state = state;
	}
	
	/**
	 * 传入状态、信息、数据
	 * @param msg
	 * @param state
	 * @param data
	 */
	public ResultBean(String msg, int state, T data) {
		super();
		this.msg = msg;
		this.state = state;
		this.data = data;
	}
	
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

	
	
	
}
