package com.nic.ws.spring.model.core;

import java.io.Serializable;

public class WS implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public String service;
	public String by="";
	public int request;
	public double avg_response_time;
}
