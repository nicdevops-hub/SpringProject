package com.nic.ws.spring.model.iosub;

	import java.io.Serializable;
	import java.util.ArrayList;

	public class OutputData_v1nic_branch_details implements Serializable{
		
		private static final long serialVersionUID = 1L;
		
		private ArrayList<Branch_Details> branchDetails;

		public ArrayList<Branch_Details> getBranchDetails() {
			return branchDetails;
		}

		public void setBranchDetails(ArrayList<Branch_Details> branchDetails) {
			this.branchDetails = branchDetails;
		}

	

	}


