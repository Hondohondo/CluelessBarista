package com.cluelessbarista.Clueless.Barista.Project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CluelessBaristaProjectApplication {

	@Bean
	public WebMvcConfigurer corsConfigurer(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry){
				registry.addMapping("/**").allowedMethods("*").allowedOrigins("*");
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(CluelessBaristaProjectApplication.class, args);
	}

}
