package org.cap.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@SequenceGenerator(initialValue=1000,name="pseq",sequenceName="pseq")
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pseq")
	private int productId;
	private String productName;
	private String description;
	private int quantity;
	private float price;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "customert_fk")
	private Customer customer;
	public Product(int productId, String productName, String description, int quantity, float price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
	}
	
	
	
	
	
}
