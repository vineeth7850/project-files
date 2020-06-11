package com.ordermanagement.Order.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ordermanagement.Order.entity.OrderDetails;

@Repository
public interface OrderRepository extends JpaRepository<OrderDetails, Integer>{

	OrderDetails findByorderid(Integer orderid);
	
//	public List<ProductsOrdered> findAllProducts();

	
}

