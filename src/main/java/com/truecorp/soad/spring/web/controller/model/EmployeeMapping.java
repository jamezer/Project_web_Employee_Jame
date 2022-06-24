package com.truecorp.soad.spring.web.controller.model;

public class EmployeeMapping {
	private String username;
	private String password;
	private String status;
	private String key;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "EmployeeMapping [username=" + username + ", password=" + password + ", status=" + status + ", key="
				+ key + "]";
	}
	
	
	
	
}
