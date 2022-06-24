package com.truecorp.soad.spring.web.controller.model;

public class EmployeeCheckLogin {
	private String userName;
	private String password;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "EmployeeCheckLogin [userName=" + userName + ", password=" + password + "]";
	}

}
