package com.nic.ws.spring.model.iosub;

import java.io.Serializable;
import java.util.ArrayList;

public class OutputData_v1nic_bank_details implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Bank_Details> bankDetails;

	public ArrayList<Bank_Details> getBankDetails() {
		return bankDetails;
	}

	public void setBankDetails(ArrayList<Bank_Details> bankDetails) {
		this.bankDetails = bankDetails;
	}


}