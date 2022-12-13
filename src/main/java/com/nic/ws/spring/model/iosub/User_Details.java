package com.nic.ws.spring.model.iosub;

import java.io.Serializable;

public class User_Details implements Serializable {
	private static final long serialVersionUID = 1L;
	private String user_cd;
	private String user_pwd;
	private String user_name;
	private String berth_dt;
	private String join_dt;
	private String fixed_pwd;
	private String other;
	private String login_ts;
	private String user_pwd_md5;
	private String entry_by;
	private String entry_ts;
	private String modify_by;
	private String modify_ts;
	public String getUser_cd() {
		return user_cd;
	}
	public void setUser_cd(String user_cd) {
		this.user_cd = user_cd;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getBerth_dt() {
		return berth_dt;
	}
	public void setBerth_dt(String berth_dt) {
		this.berth_dt = berth_dt;
	}
	public String getJoin_dt() {
		return join_dt;
	}
	public void setJoin_dt(String join_dt) {
		this.join_dt = join_dt;
	}
	public String getFixed_pwd() {
		return fixed_pwd;
	}
	public void setFixed_pwd(String fixed_pwd) {
		this.fixed_pwd = fixed_pwd;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getLogin_ts() {
		return login_ts;
	}
	public void setLogin_ts(String login_ts) {
		this.login_ts = login_ts;
	}
	public String getUser_pwd_md5() {
		return user_pwd_md5;
	}
	public void setUser_pwd_md5(String user_pwd_md5) {
		this.user_pwd_md5 = user_pwd_md5;
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
