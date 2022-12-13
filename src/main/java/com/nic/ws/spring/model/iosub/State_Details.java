package com.nic.ws.spring.model.iosub;

import java.io.Serializable;

public class State_Details implements Serializable {
	private static final long serialVersionUID = 1L;
	private String state_cd;
	private String edi_cd;
	private String satate_name;
	private String entry_by;
	private String entry_ts;
	private String modify_by;
	private String modify_ts;
	public String getState_cd() {
		return state_cd;
	}
	public void setState_cd(String state_cd) {
		this.state_cd = state_cd;
	}
	public String getEdi_cd() {
		return edi_cd;
	}
	public void setEdi_cd(String edi_cd) {
		this.edi_cd = edi_cd;
	}
	public String getSatate_name() {
		return satate_name;
	}
	public void setSatate_name(String satate_name) {
		this.satate_name = satate_name;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
