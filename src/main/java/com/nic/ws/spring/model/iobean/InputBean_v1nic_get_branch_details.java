package com.nic.ws.spring.model.iobean;
import java.io.Serializable;

public class InputBean_v1nic_get_branch_details <Branch_Details> implements Serializable {

		private static final long serialVersionUID = -138532578082853443L;
		private Branch_Details data;
		
		public Branch_Details getData() {
			return data;
		}
		public void setData(Branch_Details data) {
			this.data = data;
		}

	}



