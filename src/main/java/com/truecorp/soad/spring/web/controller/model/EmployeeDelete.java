package com.truecorp.soad.spring.web.controller.model;

public class EmployeeDelete {
	private String employeeId;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "EmployeeDelete [employeeId=" + employeeId + "]";
	}
	
}
