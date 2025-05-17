package com.dhbw.advsoft.project.wms.application;

import com.dhbw.advsoft.project.wms.domain.models.Product;

import java.util.UUID;

public class UserInputProcessorService {

    ProductService productService;

    public UserInputProcessorService(ProductService productService) {
        this.productService = productService;
    }

    public void generateProduct(String articleNumber, String name, double price, int productCategory, int count) {
        this.productService.addProduct(new Product(UUID.randomUUID().toString(), articleNumber, price, name, productCategory, count));
    }
}
