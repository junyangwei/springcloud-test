package com.example.stockapi.service.impl;

import com.example.stockapi.service.StockService;
import org.springframework.stereotype.Service;

/**
 * @author junyangwei
 * @date 2021-11-18
 */
@Service("stockService")
public class StockServiceImpl implements StockService {
    @Override
    public boolean createStock() {
        System.out.println("Begin create stock...");
        // 模拟分布式调用失败场景
//        if (true) {
//            throw new RuntimeException("错误测试，哈哈哈哈");
//        }
        return true;
    }

    private boolean createStockConfirm() {
        System.out.println("Create stock confirm...");
        return true;
    }

    private boolean createStockCancel() {
        System.out.println("Create stock cancel...");
        return true;
    }
}
