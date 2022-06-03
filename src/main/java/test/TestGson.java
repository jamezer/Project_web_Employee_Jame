package test;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.truecorp.soad.spring.jpa.Employee;

public class TestGson {
	
	static final String JDBC_driver = "";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gson Gson = new Gson();
		Cars cars = new Cars();
		
		Employee employee = new Employee();
		Employee employee2 = new Employee();
		EmpTest emptest = new EmpTest();
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		Employee[] emp = new Employee[2];
		
		
//		ArrayList<String> stringList = new ArrayList<String>();
//		stringList.add("Watcharin");
//		stringList.add("Burdok");
//		stringList.add("James");
		cars.setHonda("Civic");
		cars.setToyota("Vios");
		cars.setSuzuki("Ciazl");
//		cars.setMyList(employee);
		employee.setFirstName("Watcharin");
		employee.setEmployeeId("010N2794");
		employee2.setFirstName("James");
		employee2.setEmployeeId("010N2795");
		employeeList.add(employee);
		employeeList.add(employee2);
		cars.setEmployeeList(employeeList);
		
		String json = Gson.toJson(cars);
		System.out.println(json);
	}

}
