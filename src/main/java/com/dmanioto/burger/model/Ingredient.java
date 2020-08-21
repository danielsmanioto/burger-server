package com.dmanioto.burger.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Builder
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {
	
	@Id
	private Long id;
	
	private String description;
	
	private BigDecimal price;

}
