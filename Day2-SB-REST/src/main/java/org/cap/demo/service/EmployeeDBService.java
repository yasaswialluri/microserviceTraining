package org.cap.demo.service;

import java.util.List;

import org.cap.demo.model.Employee;

public interface EmployeeDBService {
	public List<Employee> getAllEmployees();

	public Employee findEmployeeById(Integer empId);

	public List<Employee> saveEmployee(Employee employee);

	public List<Employee> deleteEmployee(Integer empId);

	public Employee updateEmployee(Employee employee);

	public Employee updateEmail(int employeeId, String email);

}
