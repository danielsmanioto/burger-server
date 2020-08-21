package com.dmanioto.burger.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Burger {

    @Id
    private Long id;

    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Ingredient> ingredients;

    public BigDecimal getPriceTotal() {
        return this.ingredients.stream()
                .map(Ingredient::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
