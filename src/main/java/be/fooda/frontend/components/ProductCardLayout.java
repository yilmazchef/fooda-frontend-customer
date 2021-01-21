package be.fooda.frontend.components;

import be.fooda.frontend.models.product.Product;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
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
        priceField.addThemeVariants(TextFieldVariant.LUMO_ALIGN_RIGHT);
        priceField.setPrefixComponent(new Icon(VaadinIcon.EURO));
        quantityField.addValueChangeListener(onQuantityChange -> {
            priceField.setValue(data.getPrices().get(0).getAmount().multiply(BigDecimal.valueOf(quantityField.getValue())).setScale(2));
        });

        // tax info which is also recalculated every every time when price is changed ..
        Paragraph taxParagraph = new Paragraph();
        priceField.addValueChangeListener(e -> {
            BigDecimal taxValue;
            if (e.getValue() == null) {
                taxValue = BigDecimal.ZERO;
            } else {
                taxValue = e.getValue().multiply(new BigDecimal(data.getTaxes().get(0).getPercentage())).setScale(2, RoundingMode.HALF_EVEN);
            }
            taxParagraph.setText("VAT " + data.getTaxes().get(0).getPercentage() + "%: " + taxValue + data.getPrices().get(0).getCurrency());
        });

        Image productImage = new Image(data.getImages().get(0).getUrl(), data.getProductName());
        productImage.setWidth("85vw");
        productImage.setHeight("auto");

        VerticalLayout imageLayout = new VerticalLayout();
        imageLayout.setPadding(false);
        imageLayout.setWidthFull();
        imageLayout.add(productImage);

        VerticalLayout infoLayout = new VerticalLayout();
        infoLayout.setPadding(false);
        infoLayout.setWidthFull();

        final H3 nameHeader = new H3(data.getProductName());
        final Paragraph descriptionParagraph = new Paragraph(data.getDescription());
        infoLayout.add(nameHeader, descriptionParagraph);

        HorizontalLayout priceLayout = new HorizontalLayout();
        priceLayout.setPadding(false);
        priceLayout.setVerticalComponentAlignment(Alignment.CENTER);
        priceLayout.setSpacing(true);
        priceLayout.add(quantityField, priceField, taxParagraph);

        VerticalLayout actionLayout = new VerticalLayout();
        actionLayout.setPadding(false);
        actionLayout.setWidthFull();
        Button addToBasketButton = new Button(VaadinIcon.CHECK.create());
        actionLayout.add(addToBasketButton);

        add(imageLayout, infoLayout, actionLayout);
    }
}
