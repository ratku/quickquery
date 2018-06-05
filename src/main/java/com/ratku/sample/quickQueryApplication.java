package com.ratku.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class quickQueryApplication {

	public static void main(String[] args) {
		SpringApplication.run(quickQueryApplication.class, args);
	}
}
