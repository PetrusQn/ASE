package com.dhbw.advsoft.project.wms.views.components;

import com.dhbw.advsoft.project.wms.domain.models.Product;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class DetailsView extends Dialog {

    public DetailsView(Product product) {
        setWidth("400px");
        setHeight("600px");
        setHeaderTitle("Details of " + product.getName());
        this.open();
        VerticalLayout layout = new VerticalLayout();

        layout.add(new Paragraph("ID: " + product.getId()));
        layout.add(new Paragraph("Article Number: " + product.getArticleNumber()));
        layout.add(new Paragraph("Name: " + product.getName()));
        layout.add(new Paragraph("In stock " + product.getCount()));
        layout.add(new Paragraph("Category: " + product.getProductcategory()));
        layout.add(new Paragraph("Priority: " + product.getPriority()));
        layout.add(new Paragraph("Price: " + product.getPrice()));
        add(layout);

        Button okButton = new Button("OK", e -> this.close());
        getFooter().add(okButton);
    }
}
