package com.truecorp.soad.spring.web.controller.model;

public class EmployeeSearch {
	private String employeeId;
	private String empFirstName;
	private String empLastName;
	
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmpFirstName() {
		return empFirstName;
	}
	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}
	public String getEmpLastName() {
		return empLastName;
	}
	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}
	
	@Override
	public String toString() {
		return "EmployeeSearch [employeeId=" + employeeId + ", empFirstName=" + empFirstName + ", empLastName="
				+ empLastName + "]";
	}
	

}
