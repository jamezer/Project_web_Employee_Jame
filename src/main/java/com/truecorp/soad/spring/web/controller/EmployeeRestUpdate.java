package com.truecorp.soad.spring.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.truecorp.soad.spring.jpa.ElementRequest;
import com.truecorp.soad.spring.jpa.Employee;
import com.truecorp.soad.spring.jpa.EmployeeRepo;
import com.truecorp.soad.spring.web.controller.model.EmployeeInformation;
import com.truecorp.soad.spring.web.controller.model.EmployeeInformationInsert;
import com.truecorp.soad.spring.web.controller.model.EmployeeInsert;
import com.truecorp.soad.spring.web.controller.model.EmployeeListupdate;


@RestController
public class EmployeeRestUpdate {
	private Logger logger = LoggerFactory.getLogger(EmployeeRestUpdate.class);
	@Autowired
	private EmployeeRepo employeeRepo;
	
	public final String PATH_GET_EMPLOYEE = "/EmployeeInsert";
	public final String PATH_GET_EMPLOYEE_UPDATE = "/EmployeeUpdate";
	
	@RequestMapping(value=PATH_GET_EMPLOYEE_UPDATE,method = RequestMethod.POST)
	public void UpdateEmployee(@RequestBody String empdata) throws ParseException {
		Gson gson = new Gson();
		EmployeeInformation empInfo = new EmployeeInformation();
		EmployeeListupdate empupdate = gson.fromJson(empdata, EmployeeListupdate.class);
		System.out.println(empupdate.toString());
		
		Employee empId = employeeRepo.findByEmployeeId(empupdate.getEmployeeId());
		
		String sDate1 = empupdate.getAddDate();  
	    Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
	    
	    Calendar cal = new GregorianCalendar();
	    cal.setTime(date1);
		try {
			empId.setUserName(empId.getUserName());
			empId.setPassword(empId.getPassword());
			empId.setEmployeeId(empupdate.getEmployeeId());
			empId.setFirstName(empupdate.getEmpFirstName());
			empId.setLastName(empupdate.getEmpLastName());
			empId.setIsAdmin(Integer.parseInt(empupdate.getIsAdmin()));
			empId.setAddBy(empupdate.getAddBy());
			empId.setAddDate(cal);

			employeeRepo.save(empId);
			empInfo.setCode("0000");
			empInfo.setMessage("confirm");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			empInfo.setCode("9999");
		}
	}
	
	@RequestMapping(value=PATH_GET_EMPLOYEE,method = RequestMethod.POST)
	public void InsertEmployee(@RequestBody String empdata) throws ParseException {
		
		Gson gson = new Gson();
		
		EmployeeInsert empinsert = gson.fromJson(empdata, EmployeeInsert.class);
		System.out.println(empinsert.toString());
		
		
		EmployeeInformationInsert EmpInfo = new EmployeeInformationInsert();
		Employee empId = employeeRepo.findByEmployeeId(empinsert.getEmployeeId());
		
		String sDate1 = empinsert.getAddDate();  
	    Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
	    
	    Calendar cal = new GregorianCalendar();
	    cal.setTime(date1);
//	    logger.info("Time Format == "+cal.getTime());

		if (empId == null) {
			Employee emp = new Employee();
			emp.setUserName(empinsert.getUsername());
			emp.setPassword(empinsert.getPassword());
			emp.setEmployeeId(empinsert.getEmployeeId());
			emp.setFirstName(empinsert.getEmpFirstName());
			emp.setLastName(empinsert.getEmpLastName());
			emp.setIsAdmin(Integer.parseInt(empinsert.getIsAdmin()));
			emp.setAddBy(empinsert.getAddBy());
			emp.setAddDate(cal);

			employeeRepo.save(emp);
			EmpInfo.setCode("0000");
			EmpInfo.setMessage("confirm");
		} else {

			EmpInfo.setCode("9999");
			EmpInfo.setMessage("duplicate information");
		}
	}

}
