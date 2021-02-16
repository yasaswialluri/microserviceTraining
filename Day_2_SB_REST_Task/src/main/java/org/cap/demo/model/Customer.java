package org.cap.demo.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class Customer {

	private int customerId;
	private String customerName;
	private String address;
	private String mobileNumber;
	private String email;
	private List<Product> product;
}
