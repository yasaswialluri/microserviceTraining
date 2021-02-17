package org.cap.demo.model;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address {

	private int addressId;
	private String addressLine;
	private String city;
	@ManyToOne
	private Employee employee;
	public Address(int addressId, String addressLine, String city) {
		super();
		this.addressId = addressId;
		this.addressLine = addressLine;
		this.city = city;
	}
	
}
