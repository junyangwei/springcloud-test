package com.example.stockapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RestController
public class StockApiApplication {

	@Autowired
	ProductClient productClient;

	@GetMapping("/")
	public String home() {
		return "Hello, stock api.";
	}

	@GetMapping("/test")
	public String test() {
		return "Test request for stock api.";
	}

	@GetMapping("/test1")
	public String test1() {
		return productClient.test();
	}

	public static void main(String[] args) {
		SpringApplication.run(StockApiApplication.class, args);
	}

}
