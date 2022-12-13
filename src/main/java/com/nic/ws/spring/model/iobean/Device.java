package com.nic.ws.spring.model.iobean;

public class Device {
	
	private String device_type;	// web or mobile
	private String os;	// android or windows or mac
	private String dpi;
	private String ip;
	
	public String getDevice_type() {
		return device_type;
	}
	public void setDevice_type(String device_type) {
		this.device_type = device_type;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getDpi() {
		return dpi;
	}
	public void setDpi(String dpi) {
		this.dpi = dpi;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	

}
