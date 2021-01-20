package be.fooda.frontend.views.components;

import be.fooda.frontend.models.product.Product;
import be.fooda.frontend.models.product.ProductIngredient;
import com.github.appreciated.card.Card;
import com.github.appreciated.card.action.ActionButton;
import com.github.appreciated.card.label.SecondaryLabel;
import com.github.appreciated.card.label.TitleLabel;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.BigDecimalField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextFieldVariant;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.Collectors;

public class ProductCard extends VerticalLayout {
    public ProductCard(Product productData) {

        setId("product-card-" + productData.getId());

        setPadding(false);
        setMargin(false);
        setAlignItems(Alignment.CENTER);

        Image productImageData = new Image(productData.getImages().get(0).getUrl(), productData.getProductName());
        productImageData.setWidth("40vw");
        productImageData.setHeight("auto");

        NumberField quantityField = new NumberField();
        quantityField.setValue(1d);
        quantityField.setHasControls(true);
        quantityField.setMin(1);
        quantityField.setMax(productData.getLimitPerOrder());

        BigDecimalField priceField = new BigDecimalField("Total cost");
        priceField.addThemeVariants(TextFieldVariant.LUMO_ALIGN_RIGHT);
        priceField.setPrefixComponent(new Icon(VaadinIcon.EURO));

        Paragraph tax = new Paragraph();

        priceField.addValueChangeListener(e -> {
            BigDecimal taxValue;
            if (e.getValue() == null) {
                taxValue = BigDecimal.ZERO;
            } else {
                taxValue = e.getValue().multiply(new BigDecimal(productData.getTaxes().get(0).getPercentage()))
                        .setScale(2, RoundingMode.HALF_EVEN);
            }
            tax.setText("VAT " + productData.getTaxes().get(0).getPercentage() + "%: " + taxValue + productData.getPrices().get(0).getCurrency());
        });


        final String productPricesData = productData.getPrices().stream().map(productPrice -> productPrice.getTitle() + ":" + productPrice.getAmount().toPlainString() + productPrice.getCurrency()).collect(Collectors.joining());
        final String productIngredientsData = productData.getIngredients().stream().map(ProductIngredient::getIngredientName).collect(Collectors.joining());
        Card card = new Card(
                new TitleLabel(productData.getProductName()),
                new SecondaryLabel(productIngredientsData),
                quantityField,
                priceField,
                new ActionButton("Add to Basket", onClick -> {
                    priceField.setValue(productData.getPrices().get(0).getAmount().setScale(2));
                })
        );
        card.setBorderRadius("15px");
        card.setWidth("100vw");
        add(card);
    }
}