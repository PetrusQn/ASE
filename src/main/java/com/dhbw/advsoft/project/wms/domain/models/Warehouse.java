package com.dhbw.advsoft.project.wms.domain.models;

import com.dhbw.advsoft.project.wms.web.exceptions.OutOfStockException;
import jakarta.persistence.*;

@Entity
@Table(name="warehouse")
public class Warehouse {

    @Id
    @Column(name="name")
    private String name;

    @Column(name="address_id")
    private int addressId;

    @Column(name="max_stock")
    private int maxStock;

    @Column(name="stock")
    private int stock;

    public Warehouse() {}

    public Warehouse(String name, int maxStock, int addressId) {
        this.name = name;
        this.maxStock = maxStock;
        this.stock = 0;
        this.addressId = addressId;
    }

    public int getAddressId() {
        return this.addressId;
    }

    public String getName() {
        return this.name;
    }

    public int getMaxStock() {
        return this.maxStock;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int countOfItemsToAdd) {
        if (this.stock + countOfItemsToAdd <= this.maxStock) {
            this.stock += countOfItemsToAdd;
        } else {
            throw new OutOfStockException("This warehouse is not able to store the new items because there is not enough free space.");
        }
    }
}
