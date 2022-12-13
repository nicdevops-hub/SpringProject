package com.nic.ws.spring.model.iobean;

import java.io.Serializable;

import com.nic.ws.spring.model.iosub.Bank_Details;

public class InputBean_v1nic_save_bank_details implements Serializable{
	
	private static final long serialVersionUID = -138532578082853443L;
	
	private Bank_Details data;

	public Bank_Details getData() {
		return data;
	}

	public void setData(Bank_Details data) {
		this.data = data;
	}
}