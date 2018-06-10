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

	@Override
	public String toString() {
		return "OrderSale [id=" + id + ", itens=" + itens + "]";
	}

	public BigDecimal getPriceTotal() {
		double prince = 0;
		for(OrderItem i : itens) {
			prince += i.getPriceSale().doubleValue();
		}
		return BigDecimal.valueOf(prince);
	}

	
}
