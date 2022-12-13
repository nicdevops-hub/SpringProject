package com.nic.ws.spring.model.iobean;

import java.io.Serializable;

import com.nic.ws.spring.model.iosub.Student_Details;

public class InputBean_v1nic_save_stu_details implements Serializable{
	
	private static final long serialVersionUID = -138532578082853443L;
	
	private Student_Details data;

	public Student_Details getData() {
		return data;
	}

	public void setData(Student_Details data) {
		this.data = data;
	}
}
