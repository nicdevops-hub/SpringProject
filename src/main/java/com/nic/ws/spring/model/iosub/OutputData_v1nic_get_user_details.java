package com.nic.ws.spring.model.iosub;

import java.util.ArrayList;
import java.io.Serializable;

public class OutputData_v1nic_get_user_details implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<User_Details> userDetails;


	public ArrayList<User_Details> getUserDetails() {
		return userDetails;
	}


	public void setUserDetails(ArrayList<User_Details> userDetails) {
		this.userDetails = userDetails;
	}

	                                                                                       
}
