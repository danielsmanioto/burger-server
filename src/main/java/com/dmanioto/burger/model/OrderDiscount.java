package com.dmanioto.burger.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class OrderDiscount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	
	private BigDecimal value;
	
	@JsonIgnore
	@ManyToOne
	private OrderSale orderSale;

	public OrderDiscount(String description, BigDecimal value, OrderSale orderSale) {
		this.description = description;
		this.value = value;
		this.orderSale = orderSale;
	}

}
