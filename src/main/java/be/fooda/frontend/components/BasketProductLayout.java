package be.fooda.frontend.components;

import be.fooda.frontend.models.basket.BasketProduct;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.BigDecimalField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextFieldVariant;
import com.vaadin.flow.theme.material.Material;

import java.math.BigDecimal;

public class BasketProductLayout extends VerticalLayout {

    public BasketProductLayout(BasketProduct data) {

        getElement().setAttribute("theme", Material.DARK);
        setId("basket-product-layout");

        Image productImage = new Image(data.getImageUrl(), data.getName());
        productImage.addClassName("basket-product-image");

        Paragraph nameText = new Paragraph(data.getName());
        nameText.addClassName("basket-product-name");

        Paragraph descriptionText = new Paragraph(data.getDescription());
        descriptionText.addClassName("basket-product-description");

        NumberField quantityField = new NumberField();
        quantityField.addClassName("basket-product-quantity");
        quantityField.setValue(data.getQuantity().doubleValue());
        quantityField.setHasControls(true);
        quantityField.setMin(1);

        BigDecimalField totalAmountField = new BigDecimalField("TOTAL:");
        totalAmountField.addClassName("basket-product-amount");
        totalAmountField.setReadOnly(true);
        totalAmountField.addThemeVariants(TextFieldVariant.MATERIAL_ALWAYS_FLOAT_LABEL);
        totalAmountField.setPrefixComponent(new Icon(VaadinIcon.EURO));
        totalAmountField.setValue(data.getPrice().multiply(BigDecimal.valueOf(quantityField.getValue())));
        quantityField.addValueChangeListener(onQuantityChange -> {
            totalAmountField.setValue(data.getPrice().multiply(BigDecimal.valueOf(quantityField.getValue())));
        });

        totalAmountField.setReadOnly(true);
        totalAmountField.addThemeVariants(TextFieldVariant.MATERIAL_ALWAYS_FLOAT_LABEL);
        totalAmountField.setPrefixComponent(new Icon(VaadinIcon.EURO));


        add(productImage, nameText, descriptionText, quantityField, totalAmountField);
    }
}
