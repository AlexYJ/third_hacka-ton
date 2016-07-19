package com.it.nige.entities;

import java.io.Serializable;

import com.it.nige.enums.Nightingale;

public class Account implements Serializable {

	private static final long serialVersionUID = -5240956254511760812L;
	
	private double seqAccount;
	private String userId;
	private String password;
	private Nightingale nightingale;
	private int cthelp;
	private int ctcall;
	private String name;
	private String com;
	private String profileimg;
	
	public double getSeqAccount() {
		return seqAccount;
	}
	public void setSeqAccount(double seqAccount) {
		this.seqAccount = seqAccount;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getCthelp() {
		return cthelp;
	}
	public void setCthelp(int cthelp) {
		this.cthelp = cthelp;
	}
	public int getCtcall() {
		return ctcall;
	}
	public void setCtcall(int ctcall) {
		this.ctcall = ctcall;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCom() {
		return com;
	}
	public void setCom(String com) {
		this.com = com;
	}
	public String getProfileimg() {
		return profileimg;
	}
	public void setProfileimg(String profileimg) {
		this.profileimg = profileimg;
	}
	public Nightingale getNightingale() {
		return nightingale;
	}
	public void setNightingale(Nightingale nightingale) {
		this.nightingale = nightingale;
	}
	
	@Override
	public String toString() {
		return "Account [seqAccount=" + seqAccount + ", userId=" + userId + ", nightingale=" + nightingale + ", cthelp="
				+ cthelp + ", ctcall=" + ctcall + ", name=" + name + ", com=" + com + ", profileimg=" + profileimg
				+ "]";
	}
}
