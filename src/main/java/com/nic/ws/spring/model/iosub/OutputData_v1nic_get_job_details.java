package com.nic.ws.spring.model.iosub;

import java.io.Serializable;
import java.util.ArrayList;

public class OutputData_v1nic_get_job_details implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Job_Details> jobDetails;


	public ArrayList<Job_Details> getJobDetails() {
		return jobDetails;
	}


	public void setJobDetails(ArrayList<Job_Details> jobDetails) {
		this.jobDetails = jobDetails;
	}


	
	                                                                                       
}
