package com.dhbw.advsoft.project.wms.views;

import com.dhbw.advsoft.project.wms.application.ProductService;
import com.dhbw.advsoft.project.wms.domain.models.Product;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


import java.util.List;

@Route("")
public class HomeView extends VerticalLayout {
    private Div loadingScreen;
    private Div mainContent;

    public HomeView(ProductService productService) {
//        add(new H1("Welcome to your new application"));
//        add(new Paragraph("This is the home view"));
//
//        add(new Paragraph("You can edit this view in src\\main\\java\\com\\dhbw\\advsoft\\project\\wms\\views\\HomeView.java"));
//
        List<Product> productList = productService.getCachedProducts();
        for (int i=0; i < (productList.size()); i++) {
            add(new Paragraph("Name of product: " + productList.get(i).getName()));
        }
    }
}
