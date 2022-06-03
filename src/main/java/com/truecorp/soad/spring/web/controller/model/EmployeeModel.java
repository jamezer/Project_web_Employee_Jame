package com.truecorp.soad.spring.web.controller.model;

public class EmployeeModel {

	private String EmployeeID;
	private String FirstName;
	private String LastName;
	private Integer IssAdmin;
	private String AddBy;
	private String AddDate;
	
	public String getEmployeeID() {
		return EmployeeID;
	}
	public void setEmployeeID(String employeeID) {
		EmployeeID = employeeID;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public Integer getIssAdmin() {
		return IssAdmin;
	}
	public void setIssAdmin(Integer issAdmin) {
		IssAdmin = issAdmin;
	}
	public String getAddBy() {
		return AddBy;
	}
	public void setAddBy(String addBy) {
		AddBy = addBy;
	}
	public String getAddDate() {
		return AddDate;
	}
	public void setAddDate(String addDate) {
		AddDate = addDate;
	}

}
