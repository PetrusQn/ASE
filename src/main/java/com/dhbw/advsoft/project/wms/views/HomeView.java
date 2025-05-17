package com.dhbw.advsoft.project.wms.views;

import com.dhbw.advsoft.project.wms.application.ProductService;
import com.dhbw.advsoft.project.wms.application.UserInputProcessorService;
import com.dhbw.advsoft.project.wms.domain.models.Product;
import com.dhbw.advsoft.project.wms.views.components.AppControlComponent;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route("")
public class HomeView extends VerticalLayout {

    public HomeView(ProductService productService) {

        List<Product> productList = productService.getAllProducts();
        for (int i=0; i < (productList.size()); i++) {
            add(new Paragraph("Name of product: " + productList.get(i).getName()));
        }

        AppControlComponent controlComponent = new AppControlComponent(new UserInputProcessorService(productService));
        add(controlComponent);
    }
}
