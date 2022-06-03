package test;

import java.util.ArrayList;
import java.util.List;

import com.truecorp.soad.spring.jpa.Employee;

public class Cars {
	private String Honda;
	private String Toyota;
	private String Suzuki;
	
	private List<String> employee;
	private ArrayList<Employee> employeeList;
	public ArrayList<Employee> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(ArrayList<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	public List<String> getEmployee() {
		return employee;
	}
	public void setEmployee(List<String> employee) {
		this.employee = employee;
	}
	private List<String> myList;
	public List<String> getMyList() {
		return myList;
	}
	public void setMyList(List<String> myList) {
		this.myList = myList;
	}
	public String getHonda() {
		return Honda;
	}
	public void setHonda(String honda) {
		Honda = honda;
	}
	public String getToyota() {
		return Toyota;
	}
	public void setToyota(String toyota) {
		Toyota = toyota;
	}
	public String getSuzuki() {
		return Suzuki;
	}
	public void setSuzuki(String suzuki) {
		Suzuki = suzuki;
	}

}
