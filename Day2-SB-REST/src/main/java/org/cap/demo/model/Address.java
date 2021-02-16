package org.cap.demo.model;

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
}
