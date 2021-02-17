package org.cap.demo.dao;

import org.cap.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IEmployeeDBDao extends JpaRepository<Employee,Integer> {

}
