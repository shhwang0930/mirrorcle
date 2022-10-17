package com.study.model;
import org.json.simple.JSONObject;

public class UserProfile {
	
	public int getUserIdx() {
		return userIdx;
	}

	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public String getUserTemplate() {
		return userTemplate;
	}

	public void setUserTemplate(String userTemplate) {
		this.userTemplate = userTemplate;
	}

	public int getAccountIdx() {
		return accountIdx;
	}

	public void setAccountIdx(int accountIdx) {
		accountIdx = accountIdx;
	}

	private int userIdx;
	private String userId;
	private String userImage;
	private String userTemplate;
	private int accountIdx;
	
	public UserProfile(int userIdx, String userId, String userImage, String userTemplate, int accountIdx) {
		this.userIdx = userIdx;
		this.userId = userId;
		this.userImage = userImage;
		this.userTemplate = userTemplate;
		this.accountIdx = accountIdx;
	}
	
	
	
	
}
