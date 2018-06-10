package com.dmanioto.burger.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrderDiscount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	
	private BigDecimal value;
	
	@JsonIgnore
	@ManyToOne
	private OrderSale orderSale;

	public OrderDiscount() {
		// Constructor default
	}
	
	public OrderDiscount(String description, BigDecimal value, OrderSale orderSale) {
		this.description = description;
		this.value = value;
		this.orderSale = orderSale;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public OrderSale getOrderSale() {
		return orderSale;
	}

	public void setOrderSale(OrderSale orderSale) {
		this.orderSale = orderSale;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((orderSale == null) ? 0 : orderSale.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		OrderDiscount other = (OrderDiscount) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
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
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderDiscount [id=" + id + ", description=" + description + ", value=" + value + ", orderSale="
				+ orderSale + "]";
	}
	
}
