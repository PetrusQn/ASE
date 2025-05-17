package com.dhbw.advsoft.project.wms.views.components;


import com.dhbw.advsoft.project.wms.application.ProductObserver;
import com.dhbw.advsoft.project.wms.application.ProductService;
import com.dhbw.advsoft.project.wms.domain.models.Product;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.grid.ItemDoubleClickEvent;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.selection.SelectionEvent;

import java.util.List;
import java.util.Set;

public class ProductGridComponent extends VerticalLayout implements ProductObserver {

    ProductService productService;
    List<Product> productList;
    Grid<Product> productGrid;

    public ProductGridComponent(ProductService productService, AppControlComponent controlComponent) {
        this.productService = productService;
        controlComponent.addObserver(this);

        productGrid = new Grid<>(Product.class, false);
        productGrid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
        setUpGrid();

        Button deleteButton = new Button("Delete selected");
        deleteButton.setEnabled(false);

        updateGrid();
        productGrid.addSelectionListener(selection -> {
            if (selection.getAllSelectedItems().size() > 0) {
                deleteButton.setEnabled(true);
            } else {
                deleteButton.setEnabled(false);
            }
            deleteSelectionOnBtnClick(selection, deleteButton);
        });
        add(productGrid);
        add(deleteButton);
    }

    private void deleteSelectionOnBtnClick(SelectionEvent<Grid<Product>, Product> selection, Button deleteButton) {
        deleteButton.addClickListener(event -> {
            Set<Product> set = selection.getAllSelectedItems();
            for (Product productToDelete : set) {
                productService.deleteProduct(productToDelete);
            }
            this.updateGrid();
        });
    }

    private void setUpGrid() {
        productGrid.setSelectionMode(Grid.SelectionMode.MULTI);
        productGrid.addItemDoubleClickListener(event -> {
            add(new DetailsView(event.getItem()));
        });
        productGrid.addColumn(Product::getArticleNumber).setHeader("Article Number");
        productGrid.addColumn(Product::getName).setHeader("Name");
        productGrid.addColumn(Product::getProductcategory).setHeader("Category");
        productGrid.addColumn(Product::getCount).setHeader("In stock (count)");
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
