package be.fooda.frontend.components;

import be.fooda.frontend.models.product.ProductCategory;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.theme.material.Material;

import java.util.Set;

public class ProductCategoryAccordionLayout extends Accordion {

    public ProductCategoryAccordionLayout(Set<ProductCategory> categories) {

        getElement().setAttribute("theme", Material.DARK);

        setId("product-category-accordion-layout");

        FormLayout categoriesSelectionForm = new FormLayout();
        categories.forEach(c -> {
            final Checkbox categoryCheckBox = new Checkbox(c.getTitle(), false);
            categoryCheckBox.addValueChangeListener(onCheck -> {
                final Boolean checked = onCheck.getValue();

            });
            categoriesSelectionForm.add(categoryCheckBox);
        });

        setWidthFull();
        add("Categories", categoriesSelectionForm);
        close();
    }
}