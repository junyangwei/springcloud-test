package com.example.stockapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author junyangwei
 * @date 2021-11-18
 */
@FeignClient("product-service")
public interface ProductClient {

    @GetMapping("/productapi/test")
    String test();
}
