package be.fooda.frontend.components;

import be.fooda.frontend.models.basket.BasketProduct;
import be.fooda.frontend.models.product.Product;
import be.fooda.frontend.models.product.ProductPrice;
import be.fooda.frontend.models.product.ProductTax;
import be.fooda.frontend.service.BasketService;
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

public class ProductLayout extends VerticalLayout {

    public ProductLayout(Product data, BasketService basketService) {

        getElement().setAttribute("theme", Material.DARK);
        setId("product-layout");

        // number field for setting quantity  ..
        NumberField quantityField = new NumberField();
        quantityField.setValue(1d);
        quantityField.setHasControls(true);
        quantityField.setMin(1);
        quantityField.setMax(data.getLimitPerOrder());
        quantityField.addClassName("product-quantity-field");

        // price field which automatically is calculated every time the qty changes ..
        BigDecimalField priceField = new BigDecimalField("Total:");
        priceField.setReadOnly(true);
        priceField.addThemeVariants(TextFieldVariant.MATERIAL_ALWAYS_FLOAT_LABEL);
        priceField.setPrefixComponent(new Icon(VaadinIcon.EURO));
        quantityField.addValueChangeListener(onQuantityChange -> {
            final ProductPrice productPrice = data.getPrices().get(0);
            priceField.setValue(productPrice.getAmount().multiply(BigDecimal.valueOf(quantityField.getValue())).setScale(2));
        });
        priceField.addClassName("product-price-field");

        // tax info which is also recalculated every every time when price is changed ..
        BigDecimalField taxField = new BigDecimalField("Tax:");
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
        taxField.addClassName("product-tax-field");

        Image productImage = new Image(data.getImages().get(0).getUrl(), data.getProductName());
        productImage.addClassName("product-image-field");

        VerticalLayout imageLayout = new VerticalLayout();
        imageLayout.setAlignItems(Alignment.CENTER);
        imageLayout.add(productImage);
        imageLayout.addClassName("product-image-layout");

        VerticalLayout infoLayout = new VerticalLayout();
        infoLayout.setAlignItems(Alignment.CENTER);
        infoLayout.addClassName("product-info-layout");
        final H2 nameHeader = new H2(data.getProductName());
        nameHeader.addClassName("product-name-header");
        final Paragraph descriptionParagraph = new Paragraph(data.getDescription());
        descriptionParagraph.addClassName("product-description-paragraph");
        infoLayout.add(nameHeader, descriptionParagraph);

        HorizontalLayout quantityLayout = new HorizontalLayout();
        quantityLayout.setVerticalComponentAlignment(Alignment.CENTER);
        quantityLayout.addClassName("product-quantity-layout");
        quantityLayout.add(quantityField);

        HorizontalLayout priceLayout = new HorizontalLayout();
        priceLayout.setVerticalComponentAlignment(Alignment.CENTER);
        priceLayout.addClassName("product-price-layout");
        priceLayout.add(priceField, taxField);

        VerticalLayout actionLayout = new VerticalLayout();
        actionLayout.setAlignItems(Alignment.CENTER);
        actionLayout.addClassName("product-action-layout");
        Button addToBasketButton = new Button("Add to Basket", onClick -> {
            // TODO FOR AHMET .. ACTIVE THIS CODE BLOCK ..
//            basketService.addProduct(mapProductToBasketItem(data));
            new Notification(data.getProductName() + " is added to basket.");
        });
        addToBasketButton.addClassName("product-add-to-basket-button");
        actionLayout.add(addToBasketButton);

        add(imageLayout, infoLayout, quantityLayout, priceLayout, actionLayout);
    }

    private BasketProduct mapProductToBasketItem(Product product) {
        BasketProduct basketProduct = new BasketProduct();
        basketProduct.setExternalProductId(product.getId());
        basketProduct.setDescription(product.getDescription());
        ProductPrice priceUnknown = new ProductPrice();
        priceUnknown.setAmount(new BigDecimal("0.00"));
        basketProduct.setPrice(product.getPrices().stream().filter(productPrice -> productPrice.getDefault().equals(Boolean.TRUE)).findFirst().orElse(priceUnknown).getAmount());
        basketProduct.setName(product.getProductName());
        basketProduct.setImageUrl(product.getImages().get(0).getUrl());

        return basketProduct;
    }
}
