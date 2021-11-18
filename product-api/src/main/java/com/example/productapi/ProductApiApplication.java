package com.example.productapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableFeignClients
public class ProductApiApplication {

	@Autowired
	StockClient stockClient;

	@GetMapping("/")
	public String home() {
		return "Hello, product api.";
	}

	@GetMapping("/test")
	public String test() {
		return "Test request for product api.";
	}

	@GetMapping("/test1")
	public String test1() {
		return stockClient.test();
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductApiApplication.class, args);
	}

}
