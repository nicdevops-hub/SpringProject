package com.nic.ws.spring.model.iobean;

import java.io.Serializable;

import com.nic.ws.spring.model.iosub.Job_Details;

public class InputBean_v1nic_save_job_details implements Serializable {
	private static final long serialVersionUID = -138532578082853443L;
	private Job_Details data;
	public Job_Details getData() {
		return data;
	}
	public void setData(Job_Details data) {
		this.data = data;
	}
	
}
