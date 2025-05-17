package com.dhbw.advsoft.project.wms.application;

import com.dhbw.advsoft.project.wms.domain.models.Product;
import com.dhbw.advsoft.project.wms.web.exceptions.NoProductsStoredException;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    private static final String BASE_URL = "http://localhost:8080/api/v1/products";

    private final RestTemplate restTemplate;

    public ProductService() {
        this.restTemplate = new RestTemplate();
    }

    public List<Product> getAllProducts() {
        List<Product> cachedProducts;
        Product[] productsArray = restTemplate.getForObject(BASE_URL, Product[].class);
        if(productsArray != null) {
            cachedProducts = Arrays.asList(productsArray);
            return cachedProducts;
        }
        throw new NoProductsStoredException("Seems like there are no products in any of your warehouses.");
    }

    public Product addProduct(Product newProduct) {
        HttpEntity<Product> request = new HttpEntity<>(newProduct);
        return restTemplate.postForObject(BASE_URL, request, Product.class);
    }

    public void deleteProduct(Product productToDelete) {
        HttpEntity<Product> request = new HttpEntity<>(productToDelete);
        restTemplate.delete(BASE_URL + "/" + productToDelete.getId());
    }

}
