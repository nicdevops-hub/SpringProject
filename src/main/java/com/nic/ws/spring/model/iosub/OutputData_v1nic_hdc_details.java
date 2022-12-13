package com.nic.ws.spring.model.iosub;
import java.io.Serializable;
import java.util.ArrayList;

public class OutputData_v1nic_hdc_details implements Serializable{

		
		private static final long serialVersionUID = 1L;
		
		private ArrayList<Hdc_Details> hdcDetails;

		public ArrayList<Hdc_Details> getHdcDetails() {
			return hdcDetails;
		}

		public void setHdcDetails(ArrayList<Hdc_Details> hdcDetails) {
			this.hdcDetails = hdcDetails;
		}

}
