package com.dmanioto.burger;

import com.dmanioto.burger.service.impl.PreloaderDataServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class BurgerServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BurgerServerApplication.class, args);
	}

	@Bean
	public CommandLineRunner predefineValues(PreloaderDataServiceImpl preloader) {
		return (args) -> {
			preloader.persistAll();
		};
	}

}