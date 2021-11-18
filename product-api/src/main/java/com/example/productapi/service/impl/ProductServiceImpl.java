package com.example.productapi.service.impl;

import com.example.productapi.StockClient;
import com.example.productapi.service.ProductService;
import org.dromara.hmily.annotation.HmilyTCC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author junyangwei
 * @date 2021-11-18
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    StockClient stockClient;

    @HmilyTCC(confirmMethod = "createProductConfirm", cancelMethod = "createProductCancel")
    @Override
    public boolean createProduct() {
        System.out.println("Begin create product...");

        // 模拟写入商品数据
        createProductDaoOperation();

        // 调用库存服务写入库存
        stockClient.createStock();

        return true;
    }

    public boolean createProductConfirm() {
        System.out.println("Create product confirm...");
        return true;
    }

    public boolean createProductCancel() {
        System.out.println("Create product cancel...");
        return true;
    }

    /**
     * 模拟数据库操作
     * @return
     */
    private boolean createProductDaoOperation() {
        final String createProduct = "INSERT INTO products "
                + "(title, description, original_price, price) "
                + "VALUES "
                + "('测试标题', '测试商品描述', 100, 50);";

        Connection conn = null;
        try {
            // 注册 JDBC 驱动
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            // 与数据库建立连接
            System.out.println("#### 连接数据库 ####");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sell", "root", "123456");

            // 执行数据库操作
            Statement statement = conn.createStatement();
            statement.execute(createProduct);

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return true;
    }

}
