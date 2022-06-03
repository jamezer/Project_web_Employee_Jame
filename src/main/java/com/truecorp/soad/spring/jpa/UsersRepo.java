package com.truecorp.soad.spring.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<Users, Integer> {

	public Users findByEmployeeId(String employeeId);
	
	public List<Users> findByIsAdmin(Integer adminVal);
	
	public List<Users> findByFirstNameContains(String firstName);
}
