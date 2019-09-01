package com.dmanioto.burger;

import com.dmanioto.burger.fixture.MainPreloaderFixture;
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
	public CommandLineRunner predefineValues(MainPreloaderFixture preloader) {
		return (args) -> {
			preloader.persistAll();
		};
	}

}