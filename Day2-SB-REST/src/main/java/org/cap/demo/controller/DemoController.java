package org.cap.demo.controller;

import org.cap.demo.model.Address;
import org.cap.demo.model.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@RequestMapping("/")
	public String sayHello() {
		Employee employee=new Employee();
		//Employee employee2=new Employee();
		employee.setEmployeeId(1234);
		employee.setFirstName("Tom");
		employee.setLastName("Jerry");
		employee.setEmailId("Tom@gmail.com");
		
		Address address=new Address();
		address.setAddressId(1);
		address.setAddressLine("North Avvenue");
		address.setCity("Pune");
		
		employee.getAddresses().add(address);
		System.out.println(employee);
		return "Good AfterNoon";
	}
}
