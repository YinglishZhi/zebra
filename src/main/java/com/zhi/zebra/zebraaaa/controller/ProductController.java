package com.zhi.zebra.zebraaaa.controller;

import com.zhi.zebra.zebraaaa.dao.ProductDao;
import com.zhi.zebra.zebraaaa.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @GetMapping("/read")
    public List<Product> read() {
        return productDao.getAll();
    }

    @GetMapping("/write")
    public int write() {
        Product product = Product.builder()
                                 .name(UUID.randomUUID().toString())
                                 .amount(1)
                                 .build();
        return productDao.insert(product);
    }
}

