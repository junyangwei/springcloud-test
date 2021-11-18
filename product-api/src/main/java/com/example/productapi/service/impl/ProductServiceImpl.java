package com.example.productapi.service.impl;

import com.example.productapi.StockClient;
import com.example.productapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author junyangwei
 * @date 2021-11-18
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    StockClient stockClient;

    @Override
    public boolean createProduct() {
        System.out.println("Begin create product...");
        stockClient.createStock();
        return true;
    }

    private boolean createProductConfirm() {
        System.out.println("Create product confirm...");
        return true;
    }

    private boolean createProductCancel() {
        System.out.println("Create product cancel...");
        return true;
    }

}
