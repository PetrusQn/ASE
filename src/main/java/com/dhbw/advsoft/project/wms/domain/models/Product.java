package com.dhbw.advsoft.project.wms.domain.models;

import jakarta.persistence.*;

@Entity
@Table(name="products")
public class Product {
    @Id
    @Column(name="id")
    private Long id;

    @Column(name="article_number")
    private String articleNumber;

    @Column(name="count")
    private int count;

    @Column(name="price")
    private double price;

    @Column(name="name")
    private String name;

    @Column(name="min_stock")
    private int minStock;

    @Column(name="product_category")
    private int productCategory;

    @Column(name = "priority")
    private int priority;


    public Product() {}

    public Product(Long id, String articleNumber, double price, String name, int productCategory, int count) {
        this.id = id;
        this.articleNumber = articleNumber;
        this.price = price;
        this.name = name;
        this.productCategory = productCategory;
        this.count = count;
    }

    public String getArticleNumber() {
        return articleNumber;
    }

    public void setArticleNumber(String articleNumber) {
        this.articleNumber = articleNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinStock() {
        return minStock;
    }

    public void setMinStock(int minStock) {
        this.minStock = minStock;
    }

    public int getProductcategory() {
        return productCategory;
    }

    public void setProductcategory(int productcategory) {
        this.productCategory = productcategory;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
