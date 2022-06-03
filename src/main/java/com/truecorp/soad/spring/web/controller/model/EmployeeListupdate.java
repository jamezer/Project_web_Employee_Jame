package com.truecorp.soad.spring.web.controller.model;

import java.util.List;

public class EmployeeListupdate {
	private String employeeId;
	private String empFirstName;
	private String empLastName;
	private String isAdmin;
	private String addBy;
	private String addDate;
	
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
	public String getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getAddBy() {
		return addBy;
	}
	public void setAddBy(String addBy) {
		this.addBy = addBy;
	}
	public String getAddDate() {
		return addDate;
	}
	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}
	
	@Override
	public String toString() {
		return "EmployeeListupdate [employeeId=" + employeeId + ", empFirstName=" + empFirstName + ", empLastName="
				+ empLastName + ", isAdmin=" + isAdmin + ", addBy=" + addBy + ", addDate=" + addDate + "]";
	}
	

}
