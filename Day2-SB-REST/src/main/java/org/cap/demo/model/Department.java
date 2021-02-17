package org.cap.demo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@SequenceGenerator(initialValue=1000,name="depseq",sequenceName="depseq")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="depseq")
	private int departmentId;
	private String departmentName;
	

}
