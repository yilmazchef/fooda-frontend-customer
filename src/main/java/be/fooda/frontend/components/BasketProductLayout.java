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

import java.math.BigDecimal;

public class BasketProductLayout extends VerticalLayout {

    public BasketProductLayout(BasketProduct data) {

        Image productImage = new Image(data.getImageUrl(), data.getName());

        Paragraph nameText = new Paragraph(data.getName());

        Paragraph descriptionText = new Paragraph(data.getDescription());

        NumberField quantityField = new NumberField();
        quantityField.setValue(1D);
        quantityField.setHasControls(true);
        quantityField.setMin(1);

        BigDecimalField totalAmountField = new BigDecimalField("TOTAL:");
        totalAmountField.setReadOnly(true);
        totalAmountField.addThemeVariants(TextFieldVariant.MATERIAL_ALWAYS_FLOAT_LABEL);
        totalAmountField.setPrefixComponent(new Icon(VaadinIcon.EURO));
        quantityField.addValueChangeListener(onQuantityChange -> {
            totalAmountField.setValue(data.getPrice().multiply(BigDecimal.valueOf(quantityField.getValue())));
        });

        totalAmountField.setReadOnly(true);
        totalAmountField.addThemeVariants(TextFieldVariant.MATERIAL_ALWAYS_FLOAT_LABEL);
        totalAmountField.setPrefixComponent(new Icon(VaadinIcon.EURO));


        add(productImage, nameText, descriptionText, quantityField, totalAmountField);
    }
}
