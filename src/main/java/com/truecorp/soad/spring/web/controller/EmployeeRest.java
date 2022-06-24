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
import org.tempuri.AuthenRequest;
import org.tempuri.AuthenResponse;
import org.tempuri.Service_V2Soap;
import org.tempuri.Service_V2SoapProxy;

import com.google.gson.Gson;
import com.truecorp.soad.spring.jpa.ElementRequest;
import com.truecorp.soad.spring.jpa.Employee;
import com.truecorp.soad.spring.jpa.EmployeeRepo;
import com.truecorp.soad.spring.web.controller.model.EmployeeDelete;
import com.truecorp.soad.spring.web.controller.model.EmployeeInformation;
import com.truecorp.soad.spring.web.controller.model.EmployeeInformationInsert;
import com.truecorp.soad.spring.web.controller.model.EmployeeInsert;
import com.truecorp.soad.spring.web.controller.model.EmployeeMapping;
import com.truecorp.soad.spring.web.controller.model.EmployeeModel;
import com.truecorp.soad.spring.web.controller.model.EmployeeSearch;

@RestController
public class EmployeeRest {
	@Autowired
	private EmployeeRepo employeeRepo;
	
	public final String PATH_GET_EMPLOYEE = "/Employeelist";
	public final String PATH_GET_DELETE_EMPLOYEE = "/EmployeeDelete";
	public final String PATH_GET_SEARCH_EMPLOYEE = "/EmployeeSearch";
	public final String PATH_GET_CHECK_EMPLOYEE = "/EmployeeCheckLogin";
	public final String PATH_GET_REST_EMPLOYEE = "/EmployeeResonseLogin";
	
	public static final String LOGIN_HR = "HR";
	private String URL = "http://10.50.90.92/hrauthen/service_v2.asmx";
	
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
	public EmployeeInformation SearchEmployee(@RequestBody String empdata) {
		
		List<EmployeeModel> empModellist = new ArrayList<EmployeeModel>();
		EmployeeInformation EmpInfo = new EmployeeInformation();
		Gson gson = new Gson();
		
		EmployeeSearch empSearch = gson.fromJson(empdata, EmployeeSearch.class);
		System.out.println(empSearch.toString());
		
//		List<EmployeeModel> empModellist = new ArrayList<EmployeeModel>();
//		Employee list01 = employeeRepo.findByEmployeeId(empSearch.getEmployeeId());
//		EmpInfo.setEmplist(list01);
//		
//		
//		System.out.println(EmpInfo);
		
		try {
			if(empSearch.getEmployeeId() != null && empSearch.getEmpFirstName() == null && empSearch.getEmpLastName() == null) {	
				System.out.println("==1==");
				Employee list = employeeRepo.findByEmployeeId(empSearch.getEmployeeId());
				EmpInfo.setEmplist(list);
				
					EmployeeModel conemp = convert(list);
					empModellist.add(conemp);
				EmpInfo.setEmplist(empModellist);
				
			} else if (empSearch.getEmployeeId() == null && empSearch.getEmpFirstName() != null && empSearch.getEmpLastName() == null) {
				System.out.println("==2==");
				List<Employee> list = employeeRepo.findByFirstName(empSearch.getEmpFirstName());

				for (int i = 0; i < list.size(); i++) {
					Employee emp = list.get(i);
					EmployeeModel conemp = convert(emp);
					empModellist.add(conemp);
					
				}
				EmpInfo.setEmplist(empModellist);
				
			} else if (empSearch.getEmployeeId() == null && empSearch.getEmpFirstName() == null && empSearch.getEmpLastName() != null) {
				System.out.println("==3==");
				List<Employee> list = employeeRepo.findByLastName(empSearch.getEmpLastName());
				
				for (int i = 0; i < list.size(); i++) {
					Employee emp = list.get(i);
					EmployeeModel conemp = convert(emp);
					empModellist.add(conemp);
					
				}
				EmpInfo.setEmplist(empModellist);
				
			} else if (empSearch.getEmployeeId() != null && empSearch.getEmpFirstName() != null && empSearch.getEmpLastName() == null) {
				System.out.println("==4==");
				List<Employee> list = employeeRepo.findByEmployeeIdAndFirstName(empSearch.getEmployeeId(),empSearch.getEmpFirstName());

				for (int i = 0; i < list.size(); i++) {
					Employee emp = list.get(i);
					EmployeeModel conemp = convert(emp);
					empModellist.add(conemp);
					
				}
				EmpInfo.setEmplist(empModellist);
				
			} else if (empSearch.getEmployeeId() != null && empSearch.getEmpFirstName() == null && empSearch.getEmpLastName() != null) {
				System.out.println("==5==");
				List<Employee> list = employeeRepo.findByEmployeeIdAndLastName(empSearch.getEmployeeId(), empSearch.getEmpLastName());
				
				for (int i = 0; i < list.size(); i++) {
					Employee emp = list.get(i);
					EmployeeModel conemp = convert(emp);
					empModellist.add(conemp);
					
				}
				EmpInfo.setEmplist(empModellist);
				
			} else if (empSearch.getEmployeeId() == null && empSearch.getEmpFirstName() != null && empSearch.getEmpLastName() != null) {
				System.out.println("==6==");
				
				List<Employee> list = employeeRepo.findByFirstNameAndLastName(empSearch.getEmpFirstName(), empSearch.getEmpLastName());
				for (int i = 0; i < list.size(); i++) {
					Employee emp = list.get(i);
					EmployeeModel conemp = convert(emp);
					empModellist.add(conemp);
					
				}
				EmpInfo.setEmplist(empModellist);
				
			} else if (empSearch.getEmployeeId() != null && empSearch.getEmpFirstName() != null && empSearch.getEmpLastName() != null) {
				System.out.println("==7==");
				List<Employee> list = employeeRepo.findByEmployeeIdAndFirstNameAndLastName(empSearch.getEmployeeId(), empSearch.getEmpFirstName(), empSearch.getEmpLastName());
				
				for (int i = 0; i < list.size(); i++) {
					Employee emp = list.get(i);
					EmployeeModel conemp = convert(emp);
					empModellist.add(conemp);
					
				}
				EmpInfo.setEmplist(empModellist);
				
			}
			
			EmpInfo.setCode("0000");
			EmpInfo.setMessage("confirm");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return EmpInfo;
	}
	
	@RequestMapping(value=PATH_GET_CHECK_EMPLOYEE,method = RequestMethod.POST)
	public EmployeeMapping EmployeeCheckEmp(@RequestBody String empdata) {
		
		EmployeeInformation EmpInfo = new EmployeeInformation();
		Gson gson = new Gson();
		
		EmployeeMapping empSearch = gson.fromJson(empdata, EmployeeMapping.class);
		System.out.println(empSearch.toString());
		
		Employee empData = employeeRepo.findByUserName(empSearch.getUsername());
		
//		empSearch.setUsername(empData.getUserName());
//		empSearch.setPassword(empData.getPassword());
		
		try {
			
			if (empData.getUserName() != null) {
				System.out.println(empSearch.getPassword().hashCode()+" == "+empData.getPassword().hashCode());
				if (empSearch.getPassword().equals(empData.getPassword())) {
					EmpInfo.setMessage("รหัสถูกต้อง");
					EmpInfo.setCode("99");
					
					empSearch.setKey("Success9909");
					empSearch.setStatus("LoginSuccess00");
					
				} else {
					EmpInfo.setMessage("Password ไม่ถูกต้อง");
				}
			} else {
				EmpInfo.setMessage("รหัสไม่ถูกตค้อ");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			EmpInfo.setMessage("รหัสไม่ถูกตค้อง");
		}
		
		System.out.println(EmpInfo.getMessage());
//		
//		ResponseLogin(EmpInfo.getMessage());
		
		return empSearch;
		
	}
	
	@RequestMapping(value=PATH_GET_REST_EMPLOYEE ,method=RequestMethod.GET)
	public EmployeeInformation ResponseLogin(String Message) {
		
		EmployeeInformation response = new EmployeeInformation();
		System.out.println("Test == " + Message);
		response.setMessage(Message);
		System.out.println("response == " + response);
		
		return response;
		
	}
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public EmployeeModel HRLogin(String username, String password) throws Exception {

		AuthenRequest request = new AuthenRequest();
		request.setLoginType(LOGIN_HR);
		request.setUsername(username);
		request.setPassword(password);
		
		Service_V2Soap service = new Service_V2SoapProxy(URL);
		AuthenResponse response = service.authen(request);
        EmployeeModel employeeModel = null;
        if( response != null && response.getErrorCode().equals("000") ) {
        	
        	employeeModel = new EmployeeModel();
    		employeeModel.setEmployeeCode("010" + response.getEmployeeID());
    		employeeModel.setEmployeeName(response.getEmployeeName());
        	
          }else{
        	throw new Exception( response.getErrorMessage() );
        }

		return employeeModel;
	}
}
