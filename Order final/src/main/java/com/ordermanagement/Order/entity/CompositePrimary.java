package com.ordermanagement.Order.entity;

import java.io.Serializable;
import java.util.Objects;

public class CompositePrimary implements Serializable {
		private Integer orderid;
		private Integer prodid;
		
		
		public Integer getOrderid() {
			return orderid;
		}
		public void setOrderid(Integer orderid) {
			this.orderid = orderid;
		}
		public Integer getProdid() {
			return prodid;
		}
		public void setProdid(Integer prodid) {
			this.prodid = prodid;
		}
		public CompositePrimary() {
			
		}
		public CompositePrimary(Integer orderid, Integer prodid) {
	        this.orderid = orderid;
	        this.prodid = prodid;
	    }
		  @Override
		    public boolean equals(Object o) {
		        if (this == o) return true;
		        if (o == null || getClass() != o.getClass()) return false;
		        CompositePrimary primarykey = (CompositePrimary) o;
		        return orderid.equals(primarykey.orderid) &&
		                prodid.equals(primarykey.prodid);
		    }
		  
		  @Override
		    public int hashCode() {
		        return Objects.hash(orderid, prodid);
		    }
}
