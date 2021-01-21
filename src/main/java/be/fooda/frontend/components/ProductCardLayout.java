package be.fooda.frontend.components;

import be.fooda.frontend.models.product.Product;
import be.fooda.frontend.models.product.ProductPrice;
import be.fooda.frontend.models.product.ProductTax;
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
import java.math.RoundingMode;

public class ProductCardLayout extends VerticalLayout {

    public ProductCardLayout(Product data) {

        getElement().setAttribute("theme", Material.DARK);

        setId("product-card-layout");

        // product card layout design settings ..
        setPadding(false);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        setWidthFull();

        // number field for setting quantity  ..
        NumberField quantityField = new NumberField();
        quantityField.setValue(1d);
        quantityField.setHasControls(true);
        quantityField.setMin(1);
        quantityField.setMax(data.getLimitPerOrder());

        // price field which automatically is calculated every time the qty changes ..
        BigDecimalField priceField = new BigDecimalField("Total:");
        priceField.setReadOnly(true);
        priceField.addThemeVariants(TextFieldVariant.MATERIAL_ALWAYS_FLOAT_LABEL);
        priceField.setPrefixComponent(new Icon(VaadinIcon.EURO));
        quantityField.addValueChangeListener(onQuantityChange -> {
            final ProductPrice productPrice = data.getPrices().get(0);
            priceField.setValue(productPrice.getAmount().multiply(BigDecimal.valueOf(quantityField.getValue())).setScale(2));
        });

        // tax info which is also recalculated every every time when price is changed ..
        BigDecimalField taxField = new BigDecimalField("VAT:");
        taxField.setReadOnly(true);
        taxField.addThemeVariants(TextFieldVariant.MATERIAL_ALWAYS_FLOAT_LABEL);
        taxField.setPrefixComponent(new Icon(VaadinIcon.EURO));
        priceField.addValueChangeListener(e -> {
            BigDecimal taxValue;
            final ProductTax productTax = data.getTaxes().get(0);
            if (e.getValue() == null) {
                taxValue = BigDecimal.ZERO;
            } else {
                taxValue = e.getValue()
                        .multiply(new BigDecimal(productTax.getPercentage()))
                        .setScale(2, RoundingMode.HALF_EVEN);
            }
            taxField.setValue(
                    data.getPrices().get(0).getAmount()
                            .multiply(BigDecimal.valueOf(quantityField.getValue()))
                            .multiply(BigDecimal.valueOf(productTax.getPercentage()))
                            .setScale(2));
        });

        Image productImage = new Image(data.getImages().get(0).getUrl(), data.getProductName());
        productImage.setWidth("85vw");
        productImage.setHeight("auto");

        VerticalLayout imageLayout = new VerticalLayout();
        imageLayout.setAlignItems(Alignment.CENTER);
        imageLayout.add(productImage);

        VerticalLayout infoLayout = new VerticalLayout();
        infoLayout.setAlignItems(Alignment.CENTER);

        final H2 nameHeader = new H2(data.getProductName());
        nameHeader.getStyle().set("font-size", "24pt");
        final Paragraph descriptionParagraph = new Paragraph(data.getDescription());
        descriptionParagraph.getStyle().set("font-size", "12pt");
        infoLayout.add(nameHeader, descriptionParagraph);

        HorizontalLayout quantityLayout = new HorizontalLayout();
        quantityLayout.setVerticalComponentAlignment(Alignment.CENTER);
        quantityLayout.setSizeFull();
        quantityLayout.getStyle().set("font-size", "12pt");

        quantityLayout.add(quantityField);

        HorizontalLayout priceLayout = new HorizontalLayout();
        priceLayout.setVerticalComponentAlignment(Alignment.CENTER);
        priceLayout.add(priceField, taxField);

        VerticalLayout actionLayout = new VerticalLayout();
        actionLayout.setAlignItems(Alignment.CENTER);
        Button addToBasketButton = new Button("Add to Basket", onClick -> {
            new Notification("Add to basket is clicked .. ");
        });
        actionLayout.add(addToBasketButton);

        add(imageLayout, infoLayout, quantityLayout, priceLayout, actionLayout);
    }
}
