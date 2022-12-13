package com.nic.ws.spring.model.iosub;

import java.io.Serializable;

public class Bank_ac_dtls implements Serializable {
	
	private static final long serialVersionUID = -4051514544409012925L;
	
	private String bank_cd, bank_name, branch_cd, branch_name, port_ac_no;

	public String getBank_cd() {
		return bank_cd;
	}

	public void setBank_cd(String bank_cd) {
		this.bank_cd = bank_cd;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getBranch_cd() {
		return branch_cd;
	}

	public void setBranch_cd(String branch_cd) {
		this.branch_cd = branch_cd;
	}

	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	public String getPort_ac_no() {
		return port_ac_no;
	}

	public void setPort_ac_no(String port_ac_no) {
		this.port_ac_no = port_ac_no;
	}

}
