package com.dhbw.advsoft.project.wms.views;

import com.dhbw.advsoft.project.wms.application.ProductService;
import com.dhbw.advsoft.project.wms.application.UserInputProcessorService;
import com.dhbw.advsoft.project.wms.views.components.AppControlComponent;
import com.dhbw.advsoft.project.wms.views.components.ProductGridComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class HomeView extends VerticalLayout {

    public HomeView(ProductService productService) {
//        AppControlComponent controlComponent = new AppControlComponent(new UserInputProcessorService(productService));
//        add(controlComponent);
//
//        ProductGridComponent productGridComponent = new ProductGridComponent(productService, controlComponent);
//        add(productGridComponent);
    }
}
