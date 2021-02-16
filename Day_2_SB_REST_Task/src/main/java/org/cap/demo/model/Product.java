package org.cap.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
	private int productId;
	private String productName;
	private String description;
	private int quantity;
	private float price;
	
	
	
	
}
