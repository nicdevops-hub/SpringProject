package com.nic.ws.spring.model.iosub;

import java.io.Serializable;

public class Job_Details implements Serializable {
	private static final long serialVersionUID = 1L;
	private String c_seq;
	private String c_req_no;
	private String c_jd;
	private String c_jv;
	private String c_job_bl;
	public String getC_seq() {
		return c_seq;
	}
	public void setC_seq(String c_seq) {
		this.c_seq = c_seq;
	}
	public String getC_req_no() {
		return c_req_no;
	}
	public void setC_req_no(String c_req_no) {
		this.c_req_no = c_req_no;
	}
	public String getC_jd() {
		return c_jd;
	}
	public void setC_jd(String c_jd) {
		this.c_jd = c_jd;
	}
	public String getC_jv() {
		return c_jv;
	}
	public void setC_jv(String c_jv) {
		this.c_jv = c_jv;
	}
	public String getC_job_bl() {
		return c_job_bl;
	}
	public void setC_job_bl(String c_job_bl) {
		this.c_job_bl = c_job_bl;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
