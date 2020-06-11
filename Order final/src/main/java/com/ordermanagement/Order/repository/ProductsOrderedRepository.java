package com.ordermanagement.Order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ordermanagement.Order.entity.ProductsOrdered;

@Repository
public interface ProductsOrderedRepository extends JpaRepository<ProductsOrdered, Integer>{
	
	
}

