//package com.dhbw.advsoft.project.wms.domain.models;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name="food")
//public class Food extends Item {
//
//    @Id
//    @Column(name="due_date")
//    private String dueDate;
//
//    public Food() {}
//
//    public Food(String articleNumber, String name, int stock, int minStock, double pricePerUnit, Warehouse warehouse, String dueDate) {
//        super(articleNumber, name, stock, minStock, pricePerUnit, warehouse);
//        this.dueDate = dueDate;
//    }
//
//    public String getDueDate() {
//        return  this.dueDate;
//    }
//}
