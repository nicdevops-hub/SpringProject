package com.nic.ws.spring.model.iosub;

import java.io.Serializable;
import java.util.ArrayList;

public class OutputData_v1nic_emp_details implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Employee_Details> empDetails;

	public ArrayList<Employee_Details> getEmpDetails() {
		return empDetails;
	}

	public void setEmpDetails(ArrayList<Employee_Details> empDetails) {
		this.empDetails = empDetails;
	}


}
