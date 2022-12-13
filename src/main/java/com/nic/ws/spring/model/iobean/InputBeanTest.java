package com.nic.ws.spring.model.iobean;

import java.io.Serializable;

public class InputBeanTest implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Device device_info;
	
	private String from_date;
	private String to_date;
	private String user_id;

	
	
	public String getFrom_date() {
		return from_date;
	}

	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}

	public Device getDevice_info() {
		return device_info;
	}

	public void setDevice_info(Device device_info) {
		this.device_info = device_info;
	}

	public String getTo_date() {
		return to_date;
	}

	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	
}
