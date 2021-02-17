package org.cap.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@SequenceGenerator(initialValue=1000,name="myseq",sequenceName="myseq")
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="mseq")
	private int customerId;
	private String customerName;
	private String address;
	private String mobileNumber;
	private String email;
	@OneToMany(mappedBy = "customer")
	  @JsonIgnore
	private List<Product> product = new ArrayList();
}
