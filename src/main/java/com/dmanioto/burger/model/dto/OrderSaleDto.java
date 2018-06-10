package com.dmanioto.burger.model.dto;

import java.util.List;

import com.dmanioto.burger.model.Burger;
import com.dmanioto.burger.model.Ingredient;

public class OrderSaleDto {
	
	private Burger burger;
	private List<Ingredient> aditionals;
	
	public OrderSaleDto() {
		// Contructor default
	}
	
	public OrderSaleDto(Burger burger) {
		this.burger = burger;
	}
	
	public OrderSaleDto(Burger burger, List<Ingredient> aditionals) {
		this.burger = burger;
		this.aditionals = aditionals;
	}

	public Burger getBurger() {
		return burger;
	}

	public void setBurger(Burger burger) {
		this.burger = burger;
	}

	public List<Ingredient> getAditionals() {
		return aditionals;
	}

	public void setAditionals(List<Ingredient> aditionals) {
		this.aditionals = aditionals;
	}

	@Override
	public String toString() {
		return "OrderSaleDto [burger=" + burger + ", aditionals=" + aditionals + "]";
	}

}
