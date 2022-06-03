package com.truecorp.soad.spring.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.truecorp.soad.spring.jpa.Employee;
import com.truecorp.soad.spring.jpa.EmployeeRepo;
import com.truecorp.soad.spring.jpa.Users;
import com.truecorp.soad.spring.jpa.UsersRepo;
import com.truecorp.soad.spring.user.LoginService;
import com.truecorp.soad.spring.web.controller.model.EmployeeModel;


@Controller
public class IndexController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource(name="LoginService")
	private LoginService loginService;
	
	@Autowired
	private EmployeeRepo employeeRepo;

	@GetMapping(value = "/")
	public String loginPage() {
		
		return "login";
	}
	
	@RequestMapping(value = "actionLogin", method = { RequestMethod.GET, RequestMethod.POST })
	public String actionLogin(Model model , HttpServletRequest request, HttpServletResponse response ) {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String loginType = request.getParameter("logintype");
		logger.info("username id=" + request.getParameter("username") );
		logger.info("password id=" + request.getParameter("password") );
		
//		EmployeeModel employee = null;
//		try {
//				employee = loginService.cllsLogin(username, password);
//
//			if (employee != null) {
//				logger.info("employee id=" + employee.getEmployeeCode());
//				HttpSession session = request.getSession();
//				session.setAttribute("SESSION", employee);
//			
//				
//			}else {
//				logger.info("employee is null");
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		if (employee == null) {
//			model.addAttribute("error", "กรุณาระบุ Username/Password ให้ถูกต้อง");
//			return "login";
//		}
		
		
		return "redirect:/home";
	}
	
	
	@GetMapping(value = "home")
    public String welcome(Model model ,HttpServletRequest request , HttpSession session) {
		
		String webpage = "" ;
		EmployeeModel emp = (EmployeeModel) session.getAttribute("SESSION");
		
		if(emp == null ) {
			webpage = "index";
			System.out.println("Into Stand");
		}else {			
			
			System.out.println("Into Under");
			model.addAttribute("boardtitle", "Test Web");
			webpage = "index";
			List<Employee> emplist = employeeRepo.findAll();
			
			model.addAttribute("users", emplist);
			System.out.println(emplist);
		}
		
        return webpage;
    }
}
