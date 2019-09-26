package com.dmanioto.burger.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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

    public Burger(BurgerEnum e, List<Ingredient> ingredients) {
        this.id = e.id;
        this.description = e.description;
        this.ingredients = ingredients;
    }

    public BigDecimal getPriceTotal() {
        return this.ingredients
                .stream()
                .map(p -> p.getPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public enum BurgerEnum {
        X_BACON(1L, "X-Bacon"),
        X_BURGER(2L, "X-Burger"),
        X_EGG(3L, "X-Egg"),
        X_EGG_BACON(4L, "X-EggBacon");

        private final Long id;
        private final String description;

        BurgerEnum(Long id, String description) {
            this.id = id;
            this.description = description;
        }

        public Long getId() {
            return id;
        }

        public String getDescription() {
            return description;
        }
    }

}
