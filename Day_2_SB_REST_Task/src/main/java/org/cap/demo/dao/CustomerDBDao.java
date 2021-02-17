package org.cap.demo.dao;

import org.cap.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository("customerDBDao")
public interface CustomerDBDao extends JpaRepository<Customer, Integer>{

}
