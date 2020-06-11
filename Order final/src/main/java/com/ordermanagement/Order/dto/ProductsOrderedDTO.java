package com.ordermanagement.Order.dto;


import com.ordermanagement.Order.entity.ProductsOrdered;

public class ProductsOrderedDTO {
	
	Integer orderid;
	
	Integer prodid;
	
	Integer sellerid;
	
	Integer quantity;
	
	String status;
	
	Float price;
	
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Integer getProdid() {
		return prodid;
	}
	public void setProdid(Integer prodid) {
		this.prodid = prodid;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getSellerid() {
		return sellerid;
	}
	public void setSellerid(Integer sellerid) {
		this.sellerid = sellerid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public static ProductsOrderedDTO valueOf(ProductsOrdered productsordered) {
		ProductsOrderedDTO productsorderedDTO = new ProductsOrderedDTO();
		productsorderedDTO.setPrice(productsordered.getPrice());
		productsorderedDTO.setOrderid(productsordered.getCompositeprimary().getOrderid());
		productsorderedDTO.setProdid(productsordered.getCompositeprimary().getProdid());
		productsorderedDTO.setQuantity(productsordered.getQuantity());
		productsorderedDTO.setSellerid(productsordered.getSellerid());
		productsorderedDTO.setStatus(productsordered.getStatus());
		return productsorderedDTO;
	}
	@Override
	public String toString() {
		return "ProductsOrderedDTO [OrderId=" + orderid + ", ProdId=" + prodid + ", Price=" + price
				+ ", Quantity=" + quantity + ", SellerId=" + sellerid + ", Status =" + status +"]";
	}
	public ProductsOrdered createEntity() {
		// TODO Auto-generated method stub
		ProductsOrdered product=new ProductsOrdered();
		product.getCompositeprimary().setProdid(this.getProdid());
		product.getCompositeprimary().setOrderid(this.getOrderid());
		product.setQuantity(this.getQuantity());
		product.setSellerid(this.getSellerid());
		product.setStatus(this.getStatus());
		return product;
	}
	
}