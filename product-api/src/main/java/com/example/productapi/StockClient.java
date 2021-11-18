package com.example.productapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author junyangwei
 * @date 2021-11-18
 */
@FeignClient(value = "stock-service")
public interface StockClient {

    @GetMapping("/stockapi/test")
    String test();

    @GetMapping("/stockapi/create_stock")
    String createStock();
}
