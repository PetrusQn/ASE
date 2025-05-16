package com.dhbw.advsoft.project.wms.web.controllers;

import com.dhbw.advsoft.project.wms.common.Constants;
import com.dhbw.advsoft.project.wms.domain.models.Product;
import com.dhbw.advsoft.project.wms.domain.repositories.ProductRepository;
import com.dhbw.advsoft.project.wms.web.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(Constants.API_VERSIONPATH)
public class ProductController {

    private static final String BASEPATH = "/products";
    @Autowired
    private ProductRepository productRepository;

    @GetMapping(BASEPATH)
    public List<Product> getAllProducts() { return productRepository.findAll(); }

    @PostMapping(BASEPATH)
    public Product createProduct(@RequestBody Product product) { return productRepository.save(product); }

    @GetMapping(BASEPATH + "/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not exist with id: " + id));
        return ResponseEntity.ok(product);
    }

    @PutMapping(BASEPATH + "/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not exist with id: " + id));

        product.setCount(productDetails.getCount());
        product.setName(productDetails.getName());
        product.setMinStock(productDetails.getMinStock());
        product.setPrice(productDetails.getPrice());
        product.setPriority(productDetails.getPriority());
        product.setProductcategory(productDetails.getProductcategory());

        Product updatedProduct = productRepository.save(product);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping(BASEPATH + "/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not exist with id :" + id));

        productRepository.delete(product);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
