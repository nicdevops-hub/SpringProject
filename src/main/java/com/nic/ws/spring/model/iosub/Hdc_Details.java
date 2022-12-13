package com.nic.ws.spring.model.iosub;
import java.io.Serializable;
public class Hdc_Details implements Serializable{
	
		private static final long serialVersionUID = 1L;
		private String container_count;
		private String rev_amount;
		private String fiscal_year;
		
		public String getFiscal_year() {
			return fiscal_year;
		}
		public void setFiscal_year(String fiscal_year) {
			this.fiscal_year = fiscal_year;
		}
		public String getContainer_count() {
			return container_count;
		}
		public void setContainer_count(String container_count) {
			this.container_count = container_count;
		}
		public String getRev_amount() {
			return rev_amount;
		}
		public void setRev_amount(String rev_amount) {
			this.rev_amount = rev_amount;
		}


}
