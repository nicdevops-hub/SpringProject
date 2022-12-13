package com.nic.ws.spring.model.iobean;
import java.io.Serializable;

import com.nic.ws.spring.model.iosub.State_Details;
public class InputBean_v1nic_get_state_details implements Serializable{

	

		
		private static final long serialVersionUID = -138532578082853443L;
		
		private State_Details data;

		public State_Details getData() {
			return data;
		}

		public void setData(State_Details data) {
			this.data = data;
		}

		
}
