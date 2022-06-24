package com.truecorp.soad.spring.web.controller.model;

import java.util.List;

import com.truecorp.soad.spring.jpa.Employee;

public class EmployeeInformation {
	private String code;
	private String message;
	
	private List<EmployeeModel> emplist; 

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<EmployeeModel> getEmplist() {
		return emplist;
	}

	public void setEmplist(List<EmployeeModel> emplist) {
		this.emplist = emplist;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setEmplist(Employee list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "EmployeeInformation [code=" + code + ", message=" + message + ", emplist=" + emplist + "]";
	}
	
	
}
