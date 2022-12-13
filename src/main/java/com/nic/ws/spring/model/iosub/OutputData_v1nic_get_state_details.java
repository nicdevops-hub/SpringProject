package com.nic.ws.spring.model.iosub;

import java.util.ArrayList;
import java.io.Serializable;

public class OutputData_v1nic_get_state_details implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<State_Details> stateDetails;

	public ArrayList<State_Details> getStateDetails() {
		return stateDetails;
	}

	public void setStateDetails(ArrayList<State_Details> stateDetails) {
		this.stateDetails = stateDetails;
	}



	                                                                                       
}
