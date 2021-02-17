package org.cap.demo.dao;

import org.cap.demo.model.Customer;
import org.cap.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository("productDBDao")
public interface ProductDBDao  extends JpaRepository<Product, Integer> {

}
