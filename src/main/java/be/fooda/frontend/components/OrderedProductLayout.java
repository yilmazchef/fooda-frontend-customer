package be.fooda.frontend.components;

import be.fooda.frontend.models.order.OrderProduct;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.BigDecimalField;
import com.vaadin.flow.component.textfield.TextFieldVariant;
import com.vaadin.flow.theme.material.Material;

import java.math.BigDecimal;

public class OrderedProductLayout extends VerticalLayout {

    public OrderedProductLayout(OrderProduct data) {

        getElement().setAttribute("theme", Material.DARK);
        setId("ordered-item-layout");

        VerticalLayout infoLayout = new VerticalLayout();
        infoLayout.setAlignItems(Alignment.CENTER);
        infoLayout.addClassName("ordered-item-info-layout");
        final H2 nameHeader = new H2(data.getProductName());
        nameHeader.addClassName("ordered-item-name-header");
        infoLayout.add(nameHeader);

        // price field which automatically is calculated every time the qty changes ..
        BigDecimalField priceField = new BigDecimalField("Total:");
        priceField.setReadOnly(true);
        priceField.addThemeVariants(TextFieldVariant.MATERIAL_ALWAYS_FLOAT_LABEL);
        priceField.setPrefixComponent(new Icon(VaadinIcon.EURO));
        priceField.addClassName("ordered-item-price-field");
        priceField.setValue(data.getPrice().multiply(BigDecimal.valueOf(data.getQuantity())));

        HorizontalLayout priceLayout = new HorizontalLayout();
        priceLayout.setVerticalComponentAlignment(Alignment.CENTER);
        priceLayout.addClassName("ordered-item-price-layout");
        priceLayout.add(priceField);

        add(infoLayout, priceLayout);
    }
}
