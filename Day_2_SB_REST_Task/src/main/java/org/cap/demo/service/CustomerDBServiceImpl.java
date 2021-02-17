package org.cap.demo.service;
import java.util.Optional;

import javax.transaction.Transactional;

import java.util.List;

import org.cap.demo.dao.CustomerDBDao;
import org.cap.demo.dao.ICustomerDao;
import org.cap.demo.dao.ProductDBDao;
import org.cap.demo.model.Customer;
import org.cap.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerDBServiceImpl implements CustomerDBService{

	@Autowired
	private CustomerDBDao customerDbDao;
	@Autowired
	private ProductDBDao productDao;
	@Override
	public List<Customer> getAllCustomer() {
		
		return customerDbDao.findAll();
	}

	@Override
	public Customer findCustomerById(Integer cstId) {
		Optional<Customer> customer = customerDbDao.findById(cstId);
		return customer.get();
	}

	@Override
	public List<Customer> saveCustomer(Customer customer) {
		
		customerDbDao.save(customer);
		
		for(Product product:customer.getProduct()) {
			//Persist Foreign key in DB
			product.setCustomer(customer);
			productDao.save(product);
		}
		
		
		return customerDbDao.findAll();
		
	}

	@Override
	public List<Customer> deleteCustomer(Integer cstId) {
		customerDbDao.deleteById(cstId);
		return  getAllCustomer();
	}
	@Transactional
	@Override
	public Customer updateCustomer(Customer customer) {
		
		customerDbDao.save(customer);
		for(Product product:customer.getProduct()) {
			//Persist Foreign key in DB
			product.setCustomer(customer);;
			productDao.save(product);
		}
		return customer;
	}

	@Transactional
	@Override
	public Customer updateEmail(int customerId, String email) {
		Customer customer=findCustomerById(customerId);
		customer.setEmail(email);
		return customer;
	}

}
