package com.nic.ws.spring.model.iosub;

import java.io.Serializable;

public class Seq_master implements Serializable {
	
	private static final long serialVersionUID = -3508564560977720115L;
	
	private String fn_yr;
	private String prefix;
	private int seq;
	
	

	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getFn_yr() {
		return fn_yr;
	}
	public void setFn_yr(String fn_yr) {
		this.fn_yr = fn_yr;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	

}
