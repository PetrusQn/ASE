package com.dhbw.advsoft.project.wms.application;

import com.dhbw.advsoft.project.wms.domain.models.Product;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    private static final String BASE_URL = "http://localhost:8080/api/v1/products";
    private List<Product> cachedProducts;
    private final RestTemplate restTemplate;

    public ProductService() {
        this.restTemplate = new RestTemplate();
    }

    private void loadProducts() {
        Product[] productsArray = restTemplate.getForObject(BASE_URL, Product[].class);
        if(productsArray != null) {
            cachedProducts = Arrays.asList(productsArray);
        }
    }

    public List<Product> getCachedProducts() {
        this.loadProducts();
        return this.cachedProducts;
    }

    public Product addProduct(Product newProduct) {
        HttpEntity<Product> request = new HttpEntity<>(newProduct);
        return restTemplate.postForObject(BASE_URL, request, Product.class);
    }

}
