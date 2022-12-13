package com.nic.ws.spring.model.iosub;

import java.io.Serializable;

public class Branch_Details implements Serializable{
	private static final long serialVersionUID = 1L;
	private String branch_cd;
	private String bank_cd;
	private String branch_name;
	private String branch_id;
	public String getBranch_cd() {
		return branch_cd;
	}
	public void setBranch_cd(String branch_cd) {
		this.branch_cd = branch_cd;
	}
	public String getBank_cd() {
		return bank_cd;
	}
	public void setBank_cd(String bank_cd) {
		this.bank_cd = bank_cd;
	}
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	public String getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(String branch_id) {
		this.branch_id = branch_id;
	}

}
