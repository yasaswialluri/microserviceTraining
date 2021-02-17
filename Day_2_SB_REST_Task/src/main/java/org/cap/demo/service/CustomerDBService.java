package org.cap.demo.service;

import java.util.List;

import org.cap.demo.model.Customer;

public interface CustomerDBService {
	public List<Customer> getAllCustomer();

	public Customer findCustomerById(Integer cstId);

	public List<Customer> saveCustomer(Customer customer);

	public List<Customer> deleteCustomer(Integer cstId);

	public Customer updateCustomer(Customer customer);

	public Customer updateEmail(int customerId, String email);
}
