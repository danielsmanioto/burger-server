package com.dmanioto.burger.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderItem {

	@Id
	private Long id;
	
	private BigDecimal priceSale; 
	
	@ManyToOne
	private Ingredient ingredient;
	
	@ManyToOne
	private OrderSale orderSale;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getPriceSale() {
		return priceSale;
	}

	public void setPriceSale(BigDecimal priceSale) {
		this.priceSale = priceSale;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ingredient == null) ? 0 : ingredient.hashCode());
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
		if (ingredient == null) {
			if (other.ingredient != null)
				return false;
		} else if (!ingredient.equals(other.ingredient))
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
		return "OrderItem [id=" + id + ", priceSale=" + priceSale + ", ingredient=" + ingredient + ", orderSale="
				+ orderSale + "]";
	}
	
}
