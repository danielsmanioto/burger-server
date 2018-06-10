package com.dmanioto.burger.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonIgnore
	@ManyToOne
	private OrderSale orderSale;
	
	@Autowired
	private Long ingredient;
	
	private BigDecimal priceSale; 
	
	public OrderItem() {
		// Constructor default
	}
	
	public OrderItem(Long ingredient, BigDecimal price) {
		this.ingredient = ingredient;
		this.priceSale = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getIngredient() {
		return ingredient;
	}
	
	public void setIngredient(Long ingredient) {
		this.ingredient = ingredient;
	}
	
	public OrderSale getOrderSale() {
		return orderSale;
	}

	public void setOrderSale(OrderSale orderSale) {
		this.orderSale = orderSale;
	}

	public BigDecimal getPriceSale() {
		return priceSale;
	}

	public void setPriceSale(BigDecimal priceSale) {
		this.priceSale = priceSale;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((orderSale == null) ? 0 : orderSale.hashCode());
		result = prime * result + ((priceSale == null) ? 0 : priceSale.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (orderSale == null) {
			if (other.orderSale != null)
				return false;
		} else if (!orderSale.equals(other.orderSale))
			return false;
		if (priceSale == null) {
			if (other.priceSale != null)
				return false;
		} else if (!priceSale.equals(other.priceSale))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", orderSale=" + orderSale + ", priceSale=" + priceSale + "]";
	}
	
}
