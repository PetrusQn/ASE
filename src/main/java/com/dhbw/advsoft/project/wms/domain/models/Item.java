package com.dhbw.advsoft.project.wms.domain.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name="item")
public class Item {
    @Id
    @Column(name="id")
    private Long id;

    @Column(name="article_number")
    private String articleNumber;

    @Column(name="name")
    private String name;

    @Column(name="min_stock")
    private int minStock;

    @Column(name="stock")
    private int stock;

    @Column(name="price_per_unit")
    private double pricePerUnit;

    @Column(name="warehouse_name")
    private String warehouseName;

    public Item() {}

    public Item(String articleNumber, String name, int stock, int minStock, double pricePerUnit) {
        this.articleNumber = articleNumber;
        this.name = name;
        this.stock = stock;
        this.minStock = minStock;
        this.pricePerUnit = pricePerUnit;
        this.id = Math.abs(UUID.randomUUID().getLeastSignificantBits());
    }

    public double getStockPrice() {
        return (this.stock * this.pricePerUnit);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArticleNumber() {
        return articleNumber;
    }

    public void setArticleNumber(String articleNumber) {
        this.articleNumber = articleNumber;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }
}
