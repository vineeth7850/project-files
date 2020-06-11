package com.ordermanagement.Order.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ordermanagement.Order.dto.CartDTO;
import com.ordermanagement.Order.dto.OrderDetailsDTO;
import com.ordermanagement.Order.dto.ProductsOrderedDTO;
import com.ordermanagement.Order.service.OrderService;

@RestController
@EnableAutoConfiguration
@CrossOrigin
public class OrderController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public OrderService orderService;
	
	     
	//seller can view the products ordered
	@GetMapping(value = "/ViewproductsOrdered",  produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductsOrderedDTO> getProductsOrdered() {
		return orderService.getproducts();
	}
	
	
	//Buyer view the details of particular order
	@GetMapping(value= "/Vieworderdetails/{orderid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public OrderDetailsDTO getOrderById(@PathVariable Integer orderid) {
		return orderService.getOrderById(orderid);
		
	}
	
	//Buyer view the details of the orders made 
	@GetMapping(value = "/Vieworderdetails",  produces = MediaType.APPLICATION_JSON_VALUE)
	public List<OrderDetailsDTO> getOrders() {
		return orderService.getOrdersList();
	}
	
	
	// Buyer can buy the product from his cart
	@PostMapping (value="orders/placeorder",consumes=MediaType.APPLICATION_JSON_VALUE)
		public void placeOrder(@RequestBody Integer prodid) {
			logger.info("request for buy the product from cart {}", prodid);
		    final String uri= "http://localhost:3456/cart";
		   RestTemplate template=new RestTemplate();
		   CartDTO cart= template.getForObject(uri+prodid, CartDTO.class);
		    orderService.placetheOrder(cart);
	}
	
	
	//Seller manage the orders by changing the status of orders
	@PutMapping(value="orderdetails/manageOrder/{orderid}",consumes=MediaType.APPLICATION_JSON_VALUE)	
		public void manageOrder(@PathVariable Integer orderid, @RequestBody OrderDetailsDTO orderdetailsDTO) {
		orderService.ChangeStatus(orderdetailsDTO);
	}
	

	@DeleteMapping (value="/removeOrder/{orderid}", consumes= MediaType.APPLICATION_JSON_VALUE)
	public String remove(@PathVariable Integer orderid) {
		logger.info("request from the buyer {} to delete order", orderid);
		orderService.removeOrderfromlist(orderid);
		return "deleted the  order successfully";	
	}
}