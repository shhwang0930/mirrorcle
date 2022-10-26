package com.study.model;

public class ApiProfile {
	public int getApi_index() {
		return api_index;
	}
	public void setApi_index(int api_index) {
		this.api_index = api_index;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	private int api_index;
	private String name;
	private String key;
	public ApiProfile(int api_index, String name, String key) {
		super();
		this.api_index = api_index;
		this.name = name;
		this.key = key;
	}
	
}
