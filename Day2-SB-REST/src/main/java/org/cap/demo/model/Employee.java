package org.cap.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@SequenceGenerator(initialValue=1000,name="myseq",sequenceName="myseq")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="mseq")
	private int employeeId;
	private String firstName;
	private String lastName;
	private double salary;
	private String emailId;
	@OneToOne
	@JoinColumn(name="depart_fk")
	private Department department;
	
	@OneToMany(targetEntity=Address.class,mappedBy="employee")
	@JoinColumn(name="address_fk")
	private List<Address> addresses=new ArrayList();

}
