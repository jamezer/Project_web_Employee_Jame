package com.truecorp.soad.spring.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.truecorp.soad.spring.web.controller.model.EmployeeListupdate;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	public Employee findByEmployeeId(String employeeId);
	public Employee findByFirstName(String firstname);
	public Employee findByLastName(String lastname);
	public Employee findByEmployeeIdAndFirstName(String employeeId,String firstname);
	public Employee findByEmployeeIdAndLastName(String employeeId, String lastname);
	public Employee findByFirstNameAndLastName(String firstname,String lastname);
	public Employee findByEmployeeIdAndFirstNameAndLastName(String employeeId,String firstname,String lastname);
	
	public List<Employee> findByIsAdmin(Integer adminVal);
	
	public List<Employee> findByFirstNameContains(String firstName);

}
