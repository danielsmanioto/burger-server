package com.dmanioto.burger;

import com.dmanioto.burger.fixture.impl.BurgerFixtureImpl;
import com.dmanioto.burger.fixture.impl.IngredientFixtureImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BurgerServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BurgerServerApplication.class, args);
	}

	@Bean
	public CommandLineRunner predefineValues(IngredientFixtureImpl ingredient, BurgerFixtureImpl burger) {
		return (args) -> {
			ingredient.createPreDefinedData();
			burger.createPreDefinedData();
		};
	}

}