package com.dmanioto.burger.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class OrderDiscount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	
	private BigDecimal value;
	
	@JsonIgnore
	@ManyToOne
	private OrderSale orderSale;

}
