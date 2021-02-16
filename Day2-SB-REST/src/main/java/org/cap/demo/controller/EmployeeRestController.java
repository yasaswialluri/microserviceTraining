package org.cap.demo.controller;

import java.util.List;

import org.cap.demo.dao.IEmployeeDao;
import org.cap.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EmployeeRestController {
	
	@Autowired
	private IEmployeeDao employeeDao;
	
	
	@DeleteMapping("/employees/{empId}")
	public ResponseEntity<List<Employee>> deleteEmployee(@PathVariable("empId")Integer empId){
		List<Employee> employees=employeeDao.deleteEmployee(empId);
		
		if(employees==null)
			return new ResponseEntity("Sorry! Deletion Error!", HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
		
	}
	@PatchMapping("/employees/{employeeId}/{email}")
	public ResponseEntity<Employee> updateEmployeeEmail(@PathVariable("employeeId")int employeeId,@PathVariable("emailId")String email){
		
		Employee employee2 =employeeDao.updateEmail(employeeId,email);
		if(employee2==null)
			return new ResponseEntity<Employee>(employee2,HttpStatus.NOT_FOUND);
		return new ResponseEntity<Employee>(employee2,HttpStatus.OK);
	}
	
	@PutMapping("/employees")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		Employee employee2 = employeeDao.updateEmployee(employee);
		if(employee2==null)
			return new ResponseEntity<Employee>(employee2,HttpStatus.NOT_FOUND);
		return new ResponseEntity<Employee>(employee2,HttpStatus.OK);
	}
	
	@PostMapping("/employees")
	public ResponseEntity<List<Employee>> saveEmployee(@RequestBody Employee employee){
		List<Employee> employees=employeeDao.saveEmployee(employee);
		
		if(employees==null)
			return new ResponseEntity("Sorry! Insertion Error!", HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
		
	}
	
	
	
	@GetMapping("/employees/{empId}")
	public ResponseEntity<Employee> findEmployee(@PathVariable("empId")Integer empId){
		Employee employee=employeeDao.findEmployeeById(empId);
		
		if(employee==null)
			return new ResponseEntity("Sorry! Employee ID Not Found!!", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		
	}
	
	

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> employees=employeeDao.getAllEmployees();
		
		if(employees==null)
			return new ResponseEntity("Sorry! No Employee Available!", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
		
	}
	
}
