package com.ordermanagement.Order.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordermanagement.Order.dto.CartDTO;
import com.ordermanagement.Order.dto.OrderDetailsDTO;
import com.ordermanagement.Order.dto.ProductsOrderedDTO;
import com.ordermanagement.Order.entity.OrderDetails;
import com.ordermanagement.Order.entity.ProductsOrdered;
import com.ordermanagement.Order.repository.OrderRepository;
import com.ordermanagement.Order.repository.ProductsOrderedRepository;


@Service
public class OrderService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public OrderRepository orderrepo;
	
	@Autowired
	public ProductsOrderedRepository productrepo;
	
	
	public List<ProductsOrderedDTO> getproducts() {
		List<ProductsOrdered> productlist= productrepo.findAll();
		List<ProductsOrderedDTO> productsDTO = new ArrayList<>();
		
		for (ProductsOrdered productsOrder : productlist) {
			ProductsOrderedDTO productDTO = ProductsOrderedDTO.valueOf(productsOrder);
			productsDTO.add(productDTO);
		}
		logger.info("Order details : {}", productsDTO);
		return productsDTO;
		
	}
	
	
	
	public OrderDetailsDTO getOrderById(Integer orderid) {
		return OrderDetailsDTO.valueOf(orderrepo.getOne(orderid));
	}

	
	
	public List<OrderDetailsDTO> getOrdersList() {
		List<OrderDetails> order = orderrepo.findAll();
		List<OrderDetailsDTO> orderDTO = new ArrayList<>();

		for (OrderDetails orderDetails : order) {
			OrderDetailsDTO orderdetailsDTO = OrderDetailsDTO.valueOf(orderDetails);
			orderDTO.add(orderdetailsDTO);
		}

		logger.info("Order details : {}", orderDTO);
		return orderDTO;
	}
	

	public void placetheOrder(CartDTO cart) {
		ProductsOrderedDTO productsorder=new ProductsOrderedDTO();
	    productsorder.setProdid(cart.getProdid());
		ProductsOrdered order= productsorder.createEntity();
		productrepo.save(order);
	}
	

	public void removeOrderfromlist(Integer orderid) {
		OrderDetails ord=orderrepo.findByorderid(orderid);
		orderrepo.delete(ord);
		
	}

	public void ChangeStatus(OrderDetailsDTO orderdetailsDTO) {
		OrderDetails orders= orderdetailsDTO.createEntity();
		orderrepo.save(orders);
	
	}

	
}