package com.nic.ws.spring.model.iosub;

import java.io.Serializable;

public class Bank_ac implements Serializable{
	
	private static final long serialVersionUID = -138532578082853443L;
	
	private String port_ac_no,ac_cd;

	public String getPort_ac_no() {
		return port_ac_no;
	}

	public void setPort_ac_no(String port_ac_no) {
		this.port_ac_no = port_ac_no;
	}

	public String getAc_cd() {
		return ac_cd;
	}

	public void setAc_cd(String ac_cd) {
		this.ac_cd = ac_cd;
	}

}
