package com.nic.ws.spring.model.iobean;
import java.io.Serializable;

import com.nic.ws.spring.model.iosub.User_Details;

public class InputBean_v1nic_get_user_details implements Serializable{
	
	private static final long serialVersionUID = -138532578082853443L;
	private User_Details data;

	public User_Details getData() {
		return data;
	}

	public void setData(User_Details data) {
		this.data = data;
	}

}
