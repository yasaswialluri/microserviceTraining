package org.cap.demo.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicInteger;

import org.cap.demo.model.Customer;

import org.cap.demo.model.Product;
import org.springframework.stereotype.Repository;
@Repository
public class CustomerDaoImpl implements ICustomerDao{
	private static AtomicInteger customerId=new AtomicInteger(1000);

	private static AtomicInteger productId=new AtomicInteger(100);
	
	
	private static List<Customer> customers=dummyDB();
	
	private static List<Customer> dummyDB() {
		List<Customer> customers= new ArrayList<>();
		Product p1 = new Product(productId.getAndIncrement(),"laptop","asdf",1,40000);
		Product p2 =new Product(productId.getAndIncrement(),"TV","asdf",2,40000);
		List<Product> p = new ArrayList<Product>();
		p.add(p1);
		p.add(p2);
		Customer c1 = new Customer(customerId.getAndIncrement(),"yasaswi","abc1234","1234567890",
				"yas@gmail.com",p);
		Customer c2= new Customer(customerId.getAndIncrement(),"alluri","abc1234","1234567890",
				"yas@gmail.com",p);
		Customer c3 = new Customer(customerId.getAndIncrement(),"ajay","abc1234","1234567890",
				"yas@gmail.com",p);
		customers.add(c1);
		customers.add(c2);
		customers.add(c3);
		return customers;
	}
	
	@Override
	public List<Customer> getAllCustomer() {
	
		return customers;
	}

	@Override
	public Customer findCustomerById(Integer cstId) {
		for(Customer customer:customers) {
			if(customer.getCustomerId()==cstId)
				return customer;
		}
		
		return null;
	}

	@Override
	public List<Customer> saveCustomer(Customer customer) {
		customers.add(customer);
		return customers;
	}

	@Override
	public List<Customer> deleteCustomer(Integer cstId) {
		Iterator<Customer> iterator= customers.iterator();
		boolean flag=false;
		while(iterator.hasNext()) {
			Customer customer= iterator.next();
			if(customer.getCustomerId()==cstId) {
				flag=true;
				iterator.remove();
				break;
			}
		}
		
		if(flag)
			return customers;
		else
			return null;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		ListIterator<Customer>iterator =customers.listIterator();
		boolean flag = false;
		
		while(iterator.hasNext()) {
			Customer cst = iterator.next();
			if(cst.getCustomerId()==customer.getCustomerId()) {
				flag= true;
				iterator.set(customer);	
			}
			
		}
		if(flag)
			return customer;
		else
		return null;
	}

	@Override
	public Customer updateEmail(int customerId, String email) {
		ListIterator<Customer>iterator =customers.listIterator();
		boolean flag = false;
		Customer cst =null;
		while(iterator.hasNext()) {
			cst= iterator.next();
			if(cst.getCustomerId()==customerId) {
				flag= true;
				cst.setEmail(email);
				break;
			}
	
		}
		if(flag)
			return cst;
		else
		return null;
	}

}
