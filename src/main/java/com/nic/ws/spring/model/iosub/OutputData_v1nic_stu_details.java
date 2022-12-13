package com.nic.ws.spring.model.iosub;

import java.io.Serializable;
import java.util.ArrayList;

public class OutputData_v1nic_stu_details implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Student_Details> stuDetails;

	public ArrayList<Student_Details> getStuDetails() {
		return stuDetails;
	}

	public void setStuDetails(ArrayList<Student_Details> stuDetails) {
		this.stuDetails = stuDetails;
	}


}
