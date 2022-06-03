package com.truecorp.soad.spring.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.truecorp.soad.spring.jpa.ElementRequest;
import com.truecorp.soad.spring.jpa.Employee;
import com.truecorp.soad.spring.jpa.EmployeeRepo;
import com.truecorp.soad.spring.web.controller.model.EmployeeDelete;
import com.truecorp.soad.spring.web.controller.model.EmployeeInformation;
import com.truecorp.soad.spring.web.controller.model.EmployeeInformationInsert;
import com.truecorp.soad.spring.web.controller.model.EmployeeInsert;
import com.truecorp.soad.spring.web.controller.model.EmployeeModel;
import com.truecorp.soad.spring.web.controller.model.EmployeeSearch;

@RestController
public class EmployeeRest {
	@Autowired
	private EmployeeRepo employeeRepo;
	
	public final String PATH_GET_EMPLOYEE = "/Employeelist";
	public final String PATH_GET_DELETE_EMPLOYEE = "/EmployeeDelete";
	public final String PATH_GET_SEARCH_EMPLOYEE = "/EmployeeSearch";
	
//	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value=PATH_GET_EMPLOYEE ,method=RequestMethod.GET)
	public EmployeeInformation getEmployee(ElementRequest request) {
		
		EmployeeInformation response = new EmployeeInformation();
		List<EmployeeModel> empModellist = new ArrayList<EmployeeModel>();
		
		try {
			List<Employee> list = employeeRepo.findAll();
			System.out.println("List<Employee> size = " + list.size());
			
			for (int i = 0; i < list.size(); i++) {
				Employee emp = list.get(i);
				EmployeeModel conemp = convert(emp);
				empModellist.add(conemp);
				
			}
			
			response.setEmplist(empModellist);
			response.setCode("0000");
			response.setMessage("Confirm");
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.setCode("9999");
			response.setMessage(e.getMessage());
		}
		
		return response;
		
	}
	
	private EmployeeModel convert(Employee e) {
		EmployeeModel empModel = new EmployeeModel();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = formatter.format(e.getAddDate().getTime());
		
		empModel.setEmployeeID(e.getEmployeeId());
		empModel.setFirstName(e.getFirstName());
		empModel.setLastName(e.getLastName());
		empModel.setIssAdmin(e.getIsAdmin());
		empModel.setAddBy(e.getAddBy());
		empModel.setAddDate(strDate);
		return empModel;
	}
	
	@RequestMapping(value=PATH_GET_DELETE_EMPLOYEE,method = RequestMethod.POST)
	public void DeleteEmployee(@RequestBody String empdata) {
		Gson gson = new Gson();
		
		EmployeeDelete empDelete = gson.fromJson(empdata, EmployeeDelete.class);
		System.out.println(empDelete.toString());
		
		EmployeeInformation EmpInfo = new EmployeeInformation();
		Employee empId = employeeRepo.findByEmployeeId(empDelete.getEmployeeId());
		
		try {
			
			empId.setEmployeeId(empDelete.getEmployeeId());
			
			employeeRepo.delete(empId);
			EmpInfo.setCode("0000");
			EmpInfo.setMessage("confirm");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value=PATH_GET_SEARCH_EMPLOYEE,method = RequestMethod.POST)
	public void SearchEmployee(@RequestBody String empdata) {
		
		EmployeeInformation EmpInfo = new EmployeeInformation();
		Gson gson = new Gson();
		
		EmployeeSearch empSearch = gson.fromJson(empdata, EmployeeSearch.class);
		System.out.println(empSearch.toString());
		
		try {
			if(empSearch.getEmployeeId() != null && empSearch.getEmpFirstName() == null && empSearch.getEmpLastName() == null) {	
				System.out.println('1');
				Employee list = employeeRepo.findByEmployeeId(empSearch.getEmployeeId());
				EmpInfo.setEmplist(list);
			} else if (empSearch.getEmployeeId() == null && empSearch.getEmpFirstName() != null && empSearch.getEmpLastName() == null) {
				System.out.println('2');
				Employee list = employeeRepo.findByFirstName(empSearch.getEmpFirstName());
				EmpInfo.setEmplist(list);
			} else if (empSearch.getEmployeeId() == null && empSearch.getEmpFirstName() == null && empSearch.getEmpLastName() != null) {
				System.out.println('3');
				Employee list = employeeRepo.findByLastName(empSearch.getEmpLastName());
				EmpInfo.setEmplist(list);
			} else if (empSearch.getEmployeeId() != null && empSearch.getEmpFirstName() != null && empSearch.getEmpLastName() == null) {
				System.out.println('4');
				Employee list = employeeRepo.findByEmployeeIdAndFirstName(empSearch.getEmployeeId(),empSearch.getEmpFirstName());
				EmpInfo.setEmplist(list);
			} else if (empSearch.getEmployeeId() != null && empSearch.getEmpFirstName() == null && empSearch.getEmpLastName() != null) {
				System.out.println('5');
				Employee list = employeeRepo.findByEmployeeIdAndLastName(empSearch.getEmployeeId(), empSearch.getEmpLastName());
				EmpInfo.setEmplist(list);
			} else if (empSearch.getEmployeeId() == null && empSearch.getEmpFirstName() != null && empSearch.getEmpLastName() != null) {
				System.out.println('6');
				Employee list = employeeRepo.findByFirstNameAndLastName(empSearch.getEmpFirstName(), empSearch.getEmpLastName());
				EmpInfo.setEmplist(list);
			} else if (empSearch.getEmployeeId() != null && empSearch.getEmpFirstName() != null && empSearch.getEmpLastName() != null) {
				System.out.println('7');
				Employee list = employeeRepo.findByEmployeeIdAndFirstNameAndLastName(empSearch.getEmployeeId(), empSearch.getEmpFirstName(), empSearch.getEmpLastName());
				EmpInfo.setEmplist(list);
			}
			
			EmpInfo.setCode("0000");
			EmpInfo.setMessage("confirm");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
