package com.nic.ws.spring.model.iobean;

import java.io.Serializable;

import com.nic.ws.spring.model.iosub.Hdc_Details;

public class InputBean_v1nic_get_hdc_details  implements Serializable {

	private static final long serialVersionUID = -138532578082853443L;
	private Hdc_Details data;
	public Hdc_Details getData() {
		return data;
	}
	public void setData(Hdc_Details data) {
		this.data = data;
	}
	
	
	

}
