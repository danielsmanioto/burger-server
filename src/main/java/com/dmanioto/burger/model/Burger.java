package com.dmanioto.burger.model;

import com.dmanioto.burger.model.enuns.BurgerType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Burger {

    @Id
    private Long id;

    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Ingredient> ingredients;

    public Burger(BurgerType e, List<Ingredient> ingredients) {
        this.id = e.getId();
        this.description = e.getDescription();
        this.ingredients = ingredients;
    }

    public BigDecimal getPriceTotal() {
        return this.ingredients.stream()
                .map(Ingredient::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
