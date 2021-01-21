package be.fooda.frontend.components;

import be.fooda.frontend.models.store.Store;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.theme.material.Material;

public class StoreMenuItemsLayout extends Accordion {

    public StoreMenuItemsLayout(Store store) {

        getElement().setAttribute("theme", Material.DARK);

        setId("store-menu-items-layout");

        FormLayout categoriesSelectionForm = new FormLayout();
        store.getMenuItems().forEach(item -> {

            Label itemName = new Label(item.getProductName());
            


            categoriesSelectionForm.add( /* ... */);
        });

        setWidthFull();
        add("Menu", categoriesSelectionForm);
    }
}