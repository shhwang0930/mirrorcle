package com.study.model;

public class AccountProfile {
	public AccountProfile(int idx, String id, String pw, String email, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.idx = idx;
		this.email = email;
		this.name = name;
	}

	private String id;
	private String name;
	private String email;
	private String pw;
	private int idx;
	
	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
