package be.fooda.frontend.components;

import be.fooda.frontend.models.order.Order;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.theme.material.Material;

import java.awt.*;

public class OrderLayout extends VerticalLayout {

    public OrderLayout(Order data) {

        getElement().setAttribute("theme", Material.DARK);
        setId("order-layout");

        GridLayout gridLayout = new GridLayout();

        VerticalLayout infoLayout = new VerticalLayout();
        infoLayout.setAlignItems(Alignment.CENTER);
        infoLayout.addClassName("order-info-layout");
        final H2 nameHeader = new H2(data.getCustomer().getFirstName() + " " + data.getCustomer().getFirstName());
        nameHeader.addClassName("order-name-header");
        final Paragraph descriptionParagraph = new Paragraph(data.getNote());
        descriptionParagraph.addClassName("order-description-paragraph");
        infoLayout.add(nameHeader, descriptionParagraph);




        VerticalLayout actionLayout = new VerticalLayout();
        actionLayout.setAlignItems(Alignment.CENTER);
        actionLayout.addClassName("order-action-layout");
        Button viewMenuButton = new Button("Quick Re-Order", onClick -> {
            new Notification("Order with" + data.getPriceTotal() + " is reordered .. ");
        });
        viewMenuButton.addClassName("order-view-menu-button");
        actionLayout.add(viewMenuButton);

        add(infoLayout, actionLayout);
    }
}
