package com.truecorp.soad.spring.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.truecorp.soad.spring.web.controller.model.EmployeeListupdate;
import com.truecorp.soad.spring.web.controller.model.EmployeeModel;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	public Employee findByEmployeeId(String employeeId);
	public List<Employee> findByFirstName(String firstname);
	public List<Employee> findByLastName(String lastname);
	public List<Employee> findByEmployeeIdAndFirstName(String employeeId,String firstname);
	public List<Employee> findByEmployeeIdAndLastName(String employeeId, String lastname);
	public List<Employee> findByFirstNameAndLastName(String firstname,String lastname);
	public List<Employee> findByEmployeeIdAndFirstNameAndLastName(String employeeId,String firstname,String lastname);
	
	public Employee findByUserName(String username);
	
	public List<Employee> findByIsAdmin(Integer adminVal);
	
	public List<Employee> findByFirstNameContains(String firstName);

}
