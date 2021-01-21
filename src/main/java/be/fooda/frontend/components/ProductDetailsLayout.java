package be.fooda.frontend.components;

import be.fooda.frontend.models.product.Product;
import be.fooda.frontend.models.product.ProductIngredient;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.theme.material.Material;

import java.util.Set;
import java.util.stream.Collectors;

public class ProductDetailsLayout extends VerticalLayout {

    public ProductDetailsLayout(Product data) {

        getElement().setAttribute("theme", Material.DARK);
        setId("product-details-layout");

        VerticalLayout infoLayout = new VerticalLayout();
        infoLayout.addClassName("product-details-info-layout");

        H2 productNameHeader = new H2(data.getProductName());
        productNameHeader.addClassName("product-details-name");
        Paragraph descriptionParagraph = new Paragraph(data.getDescription());
        descriptionParagraph.addClassName("product-details-description");

        Accordion accordion = new Accordion();

        AccordionPanel ingredientsPanel = new AccordionPanel();

        Checkbox ingredientsCheck = new Checkbox("Select all");
        ingredientsCheck.addClassName("product-details-");
        CheckboxGroup<String> ingredientsCheckGroup = new CheckboxGroup<>();

        Set<String> items = data.getIngredients().stream().map(ProductIngredient::getIngredientName).collect(Collectors.toSet());

        ingredientsCheckGroup.setItems(items);
        ingredientsCheckGroup.addThemeVariants(CheckboxGroupVariant.MATERIAL_VERTICAL);
        ingredientsCheckGroup.addValueChangeListener(event -> {
            if (event.getValue().size() == items.size()) {
                ingredientsCheck.setValue(true);
                ingredientsCheck.setIndeterminate(false);
            } else if (!event.getValue().isEmpty()) {
                ingredientsCheck.setValue(false);
                ingredientsCheck.setIndeterminate(false);
            } else
                ingredientsCheck.setIndeterminate(true);

        });
        ingredientsCheck.addValueChangeListener(event -> {

            if (ingredientsCheck.getValue()) {
                ingredientsCheckGroup.setValue(items);
            } else {
                ingredientsCheckGroup.deselectAll();
            }
        });
        ingredientsCheckGroup.setValue(items);
        ingredientsPanel.addContent(ingredientsCheck, ingredientsCheckGroup);

        AccordionPanel extraIngredientsPanel = new AccordionPanel();

        Checkbox extraIngredientCheck = new Checkbox("Select all");
        extraIngredientCheck.addClassName("product-details-ingredients-check");
        CheckboxGroup<String> extraIngredientCheckGroup = new CheckboxGroup<>();
        extraIngredientCheckGroup.addClassName("product-details-ingredients-check-group");

        extraIngredientCheckGroup.setItems(items);
        extraIngredientCheckGroup.addThemeVariants(CheckboxGroupVariant.MATERIAL_VERTICAL);
        extraIngredientCheckGroup.addValueChangeListener(event -> {
            if (event.getValue().size() == items.size()) {
                extraIngredientCheck.setValue(true);
                extraIngredientCheck.setIndeterminate(false);
            } else if (!event.getValue().isEmpty()) {
                extraIngredientCheck.setValue(false);
                extraIngredientCheck.setIndeterminate(false);
            } else
                extraIngredientCheck.setIndeterminate(true);

        });
        extraIngredientCheck.addValueChangeListener(event -> {

            if (extraIngredientCheck.getValue()) {
                extraIngredientCheckGroup.setValue(items);
            } else {
                extraIngredientCheckGroup.deselectAll();
            }
        });
        extraIngredientCheckGroup.setValue(items);
        extraIngredientsPanel.addContent(extraIngredientCheck, extraIngredientCheckGroup);

        VerticalLayout actionsLayout = new VerticalLayout();
        actionsLayout.addClassName("product-details-actions-layout");

        // number field for setting quantity  ..
        NumberField quantityField = new NumberField();
        quantityField.addClassName("product-details-quantity");
        quantityField.setValue(1d);
        quantityField.setHasControls(true);
        quantityField.setMin(1);
        quantityField.setMax(data.getLimitPerOrder());

        Button addToBasketButton = new Button("Add to Basket", onClick -> {
            new Notification("add to basket clicked .. ");
        });
        addToBasketButton.addClassName("product-details-add-to-basket");


        accordion.add(extraIngredientsPanel);
        accordion.add(ingredientsPanel);
        add(accordion);
    }
}
