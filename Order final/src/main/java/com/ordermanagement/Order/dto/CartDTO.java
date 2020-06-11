package com.ordermanagement.Order.dto;

public class CartDTO {
	int buyerId;
	Integer prodid;
	int quantity;
	
	public int getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
	public Integer getProdid() {
		return prodid;
	}
	public void setProdId(Integer prodid) {
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
