package com.dhbw.advsoft.project.wms.views.components;


import com.dhbw.advsoft.project.wms.application.ProductObserver;
import com.dhbw.advsoft.project.wms.application.ProductService;
import com.dhbw.advsoft.project.wms.domain.models.Product;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.List;

public class ProductGridComponent extends VerticalLayout implements ProductObserver {

    ProductService productService;
    List<Product> productList;
    Grid<Product> productGrid;

    public ProductGridComponent(ProductService productService, AppControlComponent controlComponent) {
        this.productService = productService;
        controlComponent.addObserver(this);

        productGrid = new Grid<>(Product.class, false);
        productGrid.addColumn(Product::getArticleNumber).setHeader("Article Number");
        productGrid.addColumn(Product::getName).setHeader("Name");
        productGrid.addColumn(Product::getProductcategory).setHeader("Category");
        productGrid.addColumn(Product::getCount).setHeader("In stock (count)");

        updateGrid();
        add(productGrid);
    }

    public void updateGrid() {
        productList = productService.getAllProducts();
        productGrid.setItems(productList);
    }

    @Override
    public void updateProductsView() {
        this.updateGrid();
    }
}
