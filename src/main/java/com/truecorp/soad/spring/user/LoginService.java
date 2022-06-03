/**
 * 
 */
package com.truecorp.soad.spring.user;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.tempuri.AuthenRequest;
import org.tempuri.AuthenResponse;
import org.tempuri.Service_V2Soap;
import org.tempuri.Service_V2SoapProxy;

import com.truecorp.soad.spring.web.controller.model.EmployeeModel;

/**
 * @author nam
 *
 */
@Service(value="LoginService")
public class LoginService {

//	public static final String LOGIN_HR = "HR";
	public static final String LOGIN_CLLS = "CLLS";

	private String URL = "http://10.50.90.92/hrauthen/service_v2.asmx";
	
	private final String CONF_HRCLLS_LOGIN_URL = "HRCLLS_LOGIN_URL";
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 
	 */
	public LoginService() {
		
	}
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public EmployeeModel cllsLogin(String username, String password) throws Exception {

		AuthenRequest request = new AuthenRequest();
		request.setLoginType(LOGIN_CLLS);
		request.setUsername(username);
		request.setPassword(password);
		
		Service_V2Soap service = new Service_V2SoapProxy(URL);
		AuthenResponse response = service.authen(request);
        EmployeeModel employeeModel = null;
        if( response != null && response.getErrorCode().equals("000") ) {
        	
        	employeeModel = new EmployeeModel();
//    		employeeModel.setEmployeeCode("010" + response.getEmployeeID());
//    		employeeModel.setEmployeeName(response.getEmployeeName());
        	
          }else{
        	throw new Exception( response.getErrorMessage() );
        }

		return employeeModel;
	}

}
