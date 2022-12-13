package com.nic.ws.spring.model.iobean;

import java.io.Serializable;

import com.nic.ws.spring.model.iosub.Employee_Details;

public class InputBean_v1nic_get_emp_details  implements Serializable {
	
	private static final long serialVersionUID = -1425321524853443L;
	
	private Employee_Details data;

	public Employee_Details getData() {
		return data;
	}

	public void setData(Employee_Details data) {
		this.data = data;
	}
}
