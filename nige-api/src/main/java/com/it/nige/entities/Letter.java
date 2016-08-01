package com.it.nige.entities;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 감사편지 엔티티
 * 
 * @author genie
 * @date 2016.08.02
 */
public class Letter implements Serializable {

	private static final long serialVersionUID = 2220420624890689008L;
	
	private double seqAccount;
	private Account account;
	private Timestamp time;
	private String content;
	
	public double getSeqAccount() {
		return seqAccount;
	}
	public void setSeqAccount(double seqAccount) {
		this.seqAccount = seqAccount;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "Letter [seqAccount=" + seqAccount + ", account=" + account + ", time=" + time + ", content=" + content
				+ "]";
	}
}
