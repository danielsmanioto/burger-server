package com.dmanioto.burger.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class OrderSale {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<OrderItem> itens;

	@ManyToMany
	private List<OrderDiscount> discounts;
	
	public OrderSale() {
		// Constructor default
	}
	
	public OrderSale(List<OrderItem> itens) {
		this.itens = itens;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<OrderItem> getItens() {
		return itens;
	}

	public void setItens(List<OrderItem> itens) {
		this.itens = itens;
	}

	public List<OrderDiscount> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(List<OrderDiscount> discounts) {
		this.discounts = discounts;
	}

	public BigDecimal getPriceTotal() {
		double prince = 0;
		for(OrderItem i : itens) {
			prince += i.getPriceSale().doubleValue();
		}
		return BigDecimal.valueOf(prince);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((itens == null) ? 0 : itens.hashCode());
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
		OrderSale other = (OrderSale) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (itens == null) {
			if (other.itens != null)
				return false;
		} else if (!itens.equals(other.itens))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderSale [id=" + id + ", itens=" + itens + ", discounts=" + discounts + "]";
	}
	
}
