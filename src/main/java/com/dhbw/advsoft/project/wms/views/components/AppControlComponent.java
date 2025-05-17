package com.dhbw.advsoft.project.wms.views.components;

import com.dhbw.advsoft.project.wms.application.ProductObserver;
import com.dhbw.advsoft.project.wms.application.UserInputProcessorService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;

import java.util.ArrayList;

public class AppControlComponent extends HorizontalLayout {

    private Dialog dialog;
    private UserInputProcessorService userInputProcessorService;
    private ArrayList<ProductObserver> observers = new ArrayList<>();



    public AppControlComponent(UserInputProcessorService userInputProcessorService) {
        this.userInputProcessorService = userInputProcessorService;


        for(Button button : createControlButtons()) {
            add(button);
        }
        this.setUpOrderDialog();
    }

    public void addObserver(ProductObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (ProductObserver observer : observers) {
            observer.updateProductsView();
        }
    }


    private ArrayList<Button> createControlButtons() {
        ArrayList<Button> buttonList = new ArrayList<>();

        Button orderProductsButton = new Button("Order Products");
        orderProductsButton.addClickListener(event -> {
            dialog.open();
        });

        // More Buttons to add

        buttonList.add(orderProductsButton);
        return buttonList;
    }

    private void setUpOrderDialog() {
        createDialog();
        dialog.setHeaderTitle("Order product");
        dialog.add(new VerticalLayout());
        FormLayout formLayout = new FormLayout();

        TextField articleNumberField = new TextField("Article Number");
        TextField nameField = new TextField("Name");
        NumberField priceField = new NumberField("Price");
        NumberField productCtategoryField = new NumberField("Category");
        NumberField countField = new NumberField("Count");

        formLayout.add(articleNumberField);
        formLayout.add(nameField);
        formLayout.add(priceField);
        formLayout.add(productCtategoryField);
        formLayout.add(countField);

        formLayout.setResponsiveSteps(new FormLayout.ResponsiveStep("0", 1));
        dialog.add(formLayout);

        Button saveButton = new Button("Order", e -> {
            String articleNumber = articleNumberField.getValue();
            String name = nameField.getValue();
            double price = priceField.getValue();
            int productCategory = productCtategoryField.getValue().intValue();
            int count = countField.getValue().intValue();

            userInputProcessorService.generateProduct(articleNumber, name, price, productCategory, count);
            dialog.close();
            this.notifyObservers();
        });
        Button cancelButton = new Button("Cancel", e -> dialog.close());
        dialog.getFooter().add(cancelButton);
        dialog.getFooter().add(saveButton);
    }

    private void createDialog() {
        dialog = new Dialog();
        dialog.setWidth("400px");
        dialog.setHeight("600px");
    }
}
