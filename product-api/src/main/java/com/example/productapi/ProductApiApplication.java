package com.example.productapi;

import com.example.productapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@EnableEurekaClient
@RestController
@EnableFeignClients
public class ProductApiApplication {

	@Autowired
	StockClient stockClient;

	@Resource
	ProductService productService;

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

	@GetMapping("/create_product")
	public String createProduct() {
		productService.createProduct();
		return "Success createProduct!!!";
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductApiApplication.class, args);
	}

}
