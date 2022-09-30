package com.study.model;

public class UserProfile {
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAccountId() {
		return AccountId;
	}
	public int getTemplateIdx() {
		return TemplateIdx;
	}
	public int getIdx() {
		return idx;
	}
	public UserProfile(String userId) {
		super();
		this.userId = userId;
	}
	private int idx;
	private String userId;
	private String AccountId;
	private int TemplateIdx;
}
