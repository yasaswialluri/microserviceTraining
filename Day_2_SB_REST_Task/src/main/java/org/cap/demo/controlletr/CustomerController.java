package org.cap.demo.controlletr;

import java.util.List;

import org.cap.demo.dao.ICustomerDao;

import org.cap.demo.model.Customer;

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
public class CustomerController {

	
	@Autowired
	private ICustomerDao customerDao;
	
	
	@DeleteMapping("/customers/{cstId}")
	public ResponseEntity<List<Customer>> deletCustomer(@PathVariable("cstId")Integer cstId){
		List<Customer> customers=customerDao.deleteCustomer(cstId);
		
		if(customers==null)
			return new ResponseEntity("Sorry! Deletion Error!", HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
		
	}
	@PatchMapping("/customers/{customerId}/{email}")
	public ResponseEntity<Customer> updateCustomerEmail(@PathVariable("customerId")int customerId,@PathVariable("email")String email){
		
		Customer customer2 =customerDao.updateEmail(customerId, email);
		if(customer2==null)
			return new ResponseEntity<Customer>(customer2,HttpStatus.NOT_FOUND);
		return new ResponseEntity<Customer>(customer2,HttpStatus.OK);
	}
	
	@PutMapping("/customers")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
		Customer customer2 = customerDao.updateCustomer(customer);
		if(customer2==null)
			return new ResponseEntity<Customer>(customer2,HttpStatus.NOT_FOUND);
		return new ResponseEntity<Customer>(customer2,HttpStatus.OK);
	}
	
	@PostMapping("/customers")
	public ResponseEntity<List<Customer>> saveCustomer(@RequestBody Customer customer){
		List<Customer> customers=customerDao.saveCustomer(customer);
		
		if(customers==null)
			return new ResponseEntity("Sorry! Insertion Error!", HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
		
	}
	
	
	
	@GetMapping("/customers/{customerId}")
	public ResponseEntity<Customer> findCustomer(@PathVariable("customerId")Integer customerId){
		Customer customer=customerDao.findCustomerById(customerId);
		
		if(customer==null)
			return new ResponseEntity("Sorry! CustomerID Not Found!!", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		
	}
	
	

	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomer(){
		List<Customer> customers=customerDao.getAllCustomer();
		
		if(customers==null)
			return new ResponseEntity("Sorry! No CustomerAvailable!", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
		
	}
	
}
