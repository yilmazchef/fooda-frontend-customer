package be.fooda.frontend.components;

import be.fooda.frontend.models.basket.Basket;
import be.fooda.frontend.models.basket.BasketDetail;
import be.fooda.frontend.models.basket.BasketProduct;
import com.vaadin.flow.component.button.Button;
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
import java.util.List;

public class BasketLayout extends VerticalLayout {

    public BasketLayout(Basket data) {

        getElement().setAttribute("theme", Material.DARK);

        setId("basket-layout");

        List<BasketDetail> basketDetails = data.getBasketDetails();

        for (BasketDetail basketDetail : basketDetails) {
            VerticalLayout basketStoreLayout = new VerticalLayout();
            List<BasketProduct> products = basketDetail.getProducts();
            for (BasketProduct product : products) {
                VerticalLayout basketProductLayout= new VerticalLayout();

                Image productImage = new Image(product.getImageUrl(),product.getName());

                Paragraph nameText = new Paragraph(product.getName());

                Paragraph descriptionText = new Paragraph(product.getDescription());

                NumberField quantityField = new NumberField();
                quantityField.setValue(1D);
                quantityField.setHasControls(true);
                quantityField.setMin(1);

                BigDecimalField totalAmountField = new BigDecimalField("TOTAL:");
                totalAmountField.setReadOnly(true);
                totalAmountField.addThemeVariants(TextFieldVariant.MATERIAL_ALWAYS_FLOAT_LABEL);
                totalAmountField.setPrefixComponent(new Icon(VaadinIcon.EURO));
                quantityField.addValueChangeListener(onQuantityChange -> {
                    totalAmountField.setValue(product.getPrice().multiply(BigDecimal.valueOf(quantityField.getValue())));
                });

                totalAmountField.setReadOnly(true);
                totalAmountField.addThemeVariants(TextFieldVariant.MATERIAL_ALWAYS_FLOAT_LABEL);
                totalAmountField.setPrefixComponent(new Icon(VaadinIcon.EURO));


                basketProductLayout.add(productImage, nameText, descriptionText, quantityField, totalAmountField);
                basketStoreLayout.add(basketProductLayout);
            }
//            This code block is end of product loop
            add(basketStoreLayout);
        }

        Button nextButton = new Button();

        add(nextButton);
    }
}
