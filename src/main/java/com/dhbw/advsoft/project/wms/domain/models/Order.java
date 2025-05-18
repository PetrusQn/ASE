//package com.dhbw.advsoft.project.wms.domain.models;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Entity
//@Table(name="orders")
//public class Order {
//    @Id
//    @Column(name="id")
//    private Long id;
//
//    @Column(name="ordered_items")
//    private List<Item> orderedItems;
//
//    @Column(name="warehouse_delivery")
//    private Warehouse warehouseForDelivery;
//
//    @Column(name="price")
//    private double price;
//
//    @Column(name="date")
//    private String date;
//
//    public Order() {}
//
//    public Order(List<Item> orderedItems, Warehouse warehouseForDelivery) {
//        this.orderedItems = orderedItems;
//        this.warehouseForDelivery = warehouseForDelivery;
//        this.date = LocalDateTime.now().toString();
//        this.price = calcPrice();
//    }
//
//    private double calcPrice() {
//        double price = 0.0;
//        for(Item item : this.orderedItems) {
//            price += item.getPricePerUnit();
//        }
//        return price;
//    }
//
//    public String getDate() {
//        return date;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public Warehouse getWarehouseForDelivery() {
//        return warehouseForDelivery;
//    }
//
//    public List<Item> getOrderedItems() {
//        return orderedItems;
//    }
//
//    public Long getId() {
//        return id;
//    }
//}
