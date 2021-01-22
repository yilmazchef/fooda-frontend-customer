package be.fooda.frontend.components;

import be.fooda.frontend.models.basket.BasketProduct;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
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

        // number field for setting quantity  ..
        NumberField quantityField = new NumberField();
        quantityField.setValue(1d);
        quantityField.setHasControls(true);
        quantityField.setMin(1);
        quantityField.setMax(100);
        quantityField.addClassName("basket-product-quantity-field");

        // price field which automatically is calculated every time the qty changes ..
        BigDecimalField priceField = new BigDecimalField("Total:");
        priceField.setReadOnly(true);
        priceField.addThemeVariants(TextFieldVariant.MATERIAL_ALWAYS_FLOAT_LABEL);
        priceField.setPrefixComponent(new Icon(VaadinIcon.EURO));
        quantityField.addValueChangeListener(onQuantityChange -> {
            priceField.setValue(data.getPrice().multiply(BigDecimal.valueOf(quantityField.getValue())).setScale(2));
        });
        priceField.addClassName("basket-product-price-field");

        Image productImage = new Image(data.getImageUrl(), data.getName());
        productImage.addClassName("basket-product-image-field");

        VerticalLayout imageLayout = new VerticalLayout();
        imageLayout.setAlignItems(Alignment.CENTER);
        imageLayout.add(productImage);
        imageLayout.addClassName("basket-product-image-layout");

        VerticalLayout infoLayout = new VerticalLayout();
        infoLayout.setAlignItems(Alignment.CENTER);
        infoLayout.addClassName("basket-product-info-layout");
        final H2 nameHeader = new H2(data.getName());
        nameHeader.addClassName("basket-product-name-header");
        final Paragraph descriptionParagraph = new Paragraph(data.getDescription());
        descriptionParagraph.addClassName("basket-product-description-paragraph");
        infoLayout.add(nameHeader, descriptionParagraph);

        HorizontalLayout quantityLayout = new HorizontalLayout();
        quantityLayout.setVerticalComponentAlignment(Alignment.CENTER);
        quantityLayout.addClassName("basket-product-quantity-layout");
        quantityLayout.add(quantityField);

        HorizontalLayout priceLayout = new HorizontalLayout();
        priceLayout.setVerticalComponentAlignment(Alignment.CENTER);
        priceLayout.addClassName("basket-product-price-layout");
        priceLayout.add(priceField);

        VerticalLayout actionLayout = new VerticalLayout();
        actionLayout.setAlignItems(Alignment.CENTER);
        actionLayout.addClassName("basket-product-action-layout");
        Button addToBasketButton = new Button("Add to Basket", onClick -> {
            // TODO FOR AHMET .. ACTIVE THIS CODE BLOCK ..
//            basketService.addProduct(mapProductToBasketItem(data));
            new Notification(data.getName() + " is added to basket.").open();
        });
        addToBasketButton.addClassName("basket-product-add-to-basket-button");
        actionLayout.add(addToBasketButton);

        add(imageLayout, infoLayout, quantityLayout, priceLayout, actionLayout);

    }
}
