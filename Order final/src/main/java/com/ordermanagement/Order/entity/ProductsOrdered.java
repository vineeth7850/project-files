package com.ordermanagement.Order.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="productsordered")
public class ProductsOrdered implements Serializable{
	@EmbeddedId
	CompositePrimary compositeprimary;
	
	public CompositePrimary getCompositeprimary() {
		return compositeprimary;
	}
	public void setCompositeprimary(CompositePrimary compositeprimary) {
		this.compositeprimary = compositeprimary;
	}

	@Column(name="SELLERID",nullable = false)
	Integer sellerid;
	@Column(name="QUANTITY",nullable = false)
	Integer quantity;
	@Column(name="STATUS",nullable = false, length=60)
	String status;
	@Column(name="PRICE",length=10)
	Float price;
	
	
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
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
	public ProductsOrdered() {
		super();
	}
	
	
}
