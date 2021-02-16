package org.cap.demo.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {
	private int employeeId;
	private String firstName;
	private String lastName;
	private double salary;
	private String emailId;
	private Department department;
	private List<Address> addresses=new ArrayList();

}
