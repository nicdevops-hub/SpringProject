package com.nic.ws.spring.model.iosub;
import java.io.Serializable;
import java.sql.Timestamp;

public class Bank_Details implements Serializable{
	private static final long serialVersionUID = 1L;
	private String bank_cd;
	private String bank_name;
	private String bank_type;
	private String entry_by;
	private String entry_ts;
	private String modify_by;
	private String modify_ts;
	private String  active_yn;
	private String pcs_bank_cd;
	
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
	public String getBank_type() {
		return bank_type;
	}
	public void setBank_type(String bank_type) {
		this.bank_type = bank_type;
	}
	public String getEntry_by() {
		return entry_by;
	}
	public void setEntry_by(String entry_by) {
		this.entry_by = entry_by;
	}

	public String getEntry_ts() {
		return entry_ts;
	}
	public void setEntry_ts(String entry_ts) {
		this.entry_ts = entry_ts;
	}
	public String getModify_by() {
		return modify_by;
	}
	public void setModify_by(String modify_by) {
		this.modify_by = modify_by;
	}
	
	public String getModify_ts() {
		return modify_ts;
	}
	public void setModify_ts(String modify_ts) {
		this.modify_ts = modify_ts;
	}
	public String getActive_yn() {
		return active_yn;
	}
	public void setActive_yn(String active_yn) {
		this.active_yn = active_yn;
	}
	public String getPcs_bank_cd() {
		return pcs_bank_cd;
	}
	public void setPcs_bank_cd(String pcs_bank_cd) {
		this.pcs_bank_cd = pcs_bank_cd;
	}

}
