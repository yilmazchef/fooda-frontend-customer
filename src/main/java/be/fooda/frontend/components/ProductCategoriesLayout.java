package be.fooda.frontend.components;

import be.fooda.frontend.models.product.ProductCategory;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.theme.material.Material;

import java.util.Set;

public class ProductCategoriesLayout extends Accordion {

    public ProductCategoriesLayout(Set<ProductCategory> categories) {

        getElement().setAttribute("theme", Material.DARK);

        setId("product-categories-accordion");

        FormLayout categoriesSelectionForm = new FormLayout();
        categories.forEach(c -> {
            final Checkbox categoryCheckBox = new Checkbox(c.getTitle(), false);
            categoryCheckBox.addValueChangeListener(onCheck -> {
                new Notification(onCheck.getSource().getLabel() + " is " + (onCheck.getValue().equals(Boolean.TRUE) ? " is checked" : "is unchecked..")).open();
            });
            categoriesSelectionForm.add(categoryCheckBox);
        });

        add("Categories", categoriesSelectionForm);
        close();
    }
}