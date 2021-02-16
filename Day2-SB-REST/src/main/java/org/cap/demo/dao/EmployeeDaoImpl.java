package org.cap.demo.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicInteger;



import org.cap.demo.model.Address;
import org.cap.demo.model.Department;
import org.cap.demo.model.Employee;
import org.springframework.stereotype.Repository;

@Repository("employeeDao")
public class EmployeeDaoImpl implements IEmployeeDao{
	
	private static AtomicInteger departmentId=new AtomicInteger(100);
	private static AtomicInteger addressId=new AtomicInteger(1);
	
	private static AtomicInteger employeeId=new AtomicInteger(1000);
	private static List<Employee> employees=dummyDB();

	@Override
	public List<Employee> getAllEmployees() {
		
		return employees;
	}

	private static List<Employee> dummyDB() {
		
		List<Employee> employees=new ArrayList<>();
		Department sales=new Department(departmentId.getAndIncrement(),"Sales");
		Department purchase=new Department(departmentId.getAndIncrement(),"Sales");
		Department finance=new Department(departmentId.getAndIncrement(),"Sales");
		Department marketing=new Department(departmentId.getAndIncrement(),"Sales");
		
		Address tom=new Address(addressId.getAndIncrement(), "North Avvenue", "Pune");
		Address tom1=new Address(addressId.getAndIncrement(), "WestCar street", "Chennai");
		
		List<Address> tomaddress=new ArrayList<Address>();
		tomaddress.add(tom);tomaddress.add(tom1);
		Employee employee=new Employee(employeeId.getAndIncrement(),"Tom","Jerry",23000,
				"tom@gmail.com",sales,tomaddress);
		
		
		
		Address ram=new Address(addressId.getAndIncrement(), "Plot7 West Avvenue", "Pune");
		Address ram1=new Address(addressId.getAndIncrement(), "Flat23 South Street", "Mumbai");
		
		List<Address> ramaddress=new ArrayList<Address>();
		ramaddress.add(ram);ramaddress.add(ram1);
		
		Employee employeeram=new Employee(employeeId.getAndIncrement(),"Ram","Singh",45000,
				"ram@gmail.com",purchase,ramaddress);
		
		employees.add(employee);
		employees.add(employeeram);
		
		
		
		return employees;
	}

	@Override
	public Employee findEmployeeById(Integer empId) {
		
		for(Employee employee:employees) {
			if(employee.getEmployeeId()==empId)
				return employee;
		}
		
		return null;
	}

	@Override
	public List<Employee> saveEmployee(Employee employee) {
		employees.add(employee);
		return employees;
	}

	@Override
	public List<Employee> deleteEmployee(Integer empId) {
		Iterator<Employee> iterator= employees.iterator();
		boolean flag=false;
		while(iterator.hasNext()) {
			Employee  employee= iterator.next();
			if(employee.getEmployeeId()==empId) {
				flag=true;
				iterator.remove();
				break;
			}
		}
		
		if(flag)
			return employees;
		else
			return null;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		//Employee employee2=findEmployeeById(employee.getEmployeeId());
		ListIterator<Employee>iterator =employees.listIterator();
		boolean flag = false;
		
		while(iterator.hasNext()) {
			Employee emp = iterator.next();
			if(emp.getEmployeeId()==employee.getEmployeeId()) {
				flag= true;
				iterator.set(employee);	
			}
			
		}
		if(flag)
			return employee;
		else
		return null;
	}

	@Override
	public Employee updateEmail(int employeeId, String email) {
		ListIterator<Employee>iterator =employees.listIterator();
		boolean flag = false;
		Employee emp =null;
		while(iterator.hasNext()) {
			emp= iterator.next();
			if(emp.getEmployeeId()==employeeId) {
				flag= true;
				emp.setEmailId(email);
				break;
			}
			
		}
		if(flag)
			return emp;
		else
		return null;
	}

}















		
		
		
