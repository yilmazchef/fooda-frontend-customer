package be.fooda.frontend.layout;

import be.fooda.frontend.model.product.Price;
import be.fooda.frontend.model.product.Product;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Optional;

@Tag("vaadin-product-layout")
public class ProductLayout extends Component implements HasComponents, Serializable {

    private final VerticalLayout productImageLayout = new VerticalLayout();
    private final Image productImg = new Image();

    private final VerticalLayout productInfoLayout = new VerticalLayout();
    private final H2 productNameH2 = new H2();
    private final Paragraph productDescriptionP = new Paragraph();

    private final HorizontalLayout productPriceLayout = new HorizontalLayout();
    private final BigDecimalField productPriceField = new BigDecimalField();
    private final BigDecimalField productTaxField = new BigDecimalField();
    private final BigDecimalField totalPriceField = new BigDecimalField();

    public ProductLayout(Product data) {

//        START -> PRODUCT IMAGE LAYOUT COMPONENTS
        productImg.setWidth("100%");
        productImg.setHeight("auto");
        productImg.setSrc(data.getDefaultImage().getUrl());
        productImg.setAlt(data.getName());
        productImageLayout.add(productImg);

//        END -> PRODUCT IMAGE LAYOUT COMPONENTS

//        START -> PRODUCT INFO LAYOUT COMPONENTS
        productNameH2.setText(data.getName());
        productDescriptionP.setText(data.getDescription());
        productInfoLayout.add(productNameH2, productDescriptionP);

//        END -> PRODUCT INFO LAYOUT COMPONENTS
        final Optional<Price> defaultPrice = data.getPrices().stream().filter(Price::getDefault).findFirst();
        if (defaultPrice.isPresent())
            productPriceField.setValue(defaultPrice.get().getAmount());
        else
            productPriceField.setValue(BigDecimal.ZERO);


    }
}
