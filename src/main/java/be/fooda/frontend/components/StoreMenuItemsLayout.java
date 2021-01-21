package be.fooda.frontend.components;

import be.fooda.frontend.models.store.Store;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.theme.material.Material;

public class StoreMenuItemsLayout extends Accordion {

    public StoreMenuItemsLayout(Store store) {

        getElement().setAttribute("theme", Material.DARK);
        setId("store-menu-items-accordion");

        HorizontalLayout menuItemsFormLayout = new HorizontalLayout();
        menuItemsFormLayout.addClassName("store-menu-items-layout");
        store.getMenuItems().forEach(item -> {
            Label itemNameLabel = new Label(item.getProductName());
            Label itemCuisineLabel = new Label(item.getCuisine());
            itemNameLabel.addClassName("store-menu-item-name");
            Button viewItemDetailsButton = new Button(VaadinIcon.PLUS.create(), onClick -> {
                new Notification(item.getProductName() + " is clicked.. ");
            });
            menuItemsFormLayout.add(itemNameLabel, itemCuisineLabel, viewItemDetailsButton);
        });

        add("Menu", menuItemsFormLayout);
    }
}