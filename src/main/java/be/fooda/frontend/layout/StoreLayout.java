package be.fooda.frontend.layout;

import be.fooda.frontend.model.store.Product;
import be.fooda.frontend.model.store.Store;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.BigDecimalField;
import com.vaadin.flow.component.textfield.TextFieldVariant;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Tag("vaadin-store-layout")
public class StoreLayout extends Component implements HasComponents, HasStyle, Serializable {

    private final VerticalLayout imageLayout = new VerticalLayout();
    private final Image storeImg = new Image();

    private final VerticalLayout infoLayout = new VerticalLayout();
    private final H2 storeNameH2 = new H2();
    private final Paragraph storeDescriptionP = new Paragraph();

    private final VerticalLayout menuLayout = new VerticalLayout();
    private final VerticalLayout detailsLayout = new VerticalLayout();
    private final VerticalLayout commentsLayout = new VerticalLayout();

    private final HorizontalLayout actionsLayout = new HorizontalLayout();
    private final Button menuButton = new Button("Menu");
    private final Button detailsButton = new Button("Delivery");
    private final Button commentsButton = new Button("Comments");

    public StoreLayout(Store data) {

        addClassName("card");

        storeImg.setSrc(data.getBgImage().getUrl());
        storeImg.setAlt(data.getName());
        storeImg.addClassName("card-image");
        imageLayout.add(storeImg);

        storeNameH2.setText(data.getName());
        storeNameH2.addClassName("card-title");
        storeDescriptionP.setText(data.getAbout());
        storeDescriptionP.addClassName("card-description");
        infoLayout.add(storeNameH2, storeDescriptionP);

        List<Product> products = data.getProducts();
        for (Product product : products) {

            HorizontalLayout productLayout = new HorizontalLayout();

            Image productImage = new Image(product.getImageUrl(), product.getName());
            productImage.addClassName("card-image-small");
            Label productNameLabel = new Label(product.getName());
            productNameLabel.addClassName("card-title-small");
            BigDecimalField productPriceField = new BigDecimalField();
            final BigDecimal productPriceValue = product.getPrice();
            productPriceField.addThemeVariants(TextFieldVariant.LUMO_ALIGN_RIGHT);
            productPriceField.setPrefixComponent(new Icon(VaadinIcon.EURO));
            productPriceField.setValue(productPriceValue.setScale(2, RoundingMode.HALF_EVEN));
            productPriceField.setReadOnly(true);
            productPriceField.addClassName("card-number-small");
            Button addButton = new Button(VaadinIcon.CART.create(), onClick -> {
                new Notification(product.getName() + " is added.", 1000, Notification.Position.BOTTOM_CENTER).open();
            });
            productLayout.setAlignItems(FlexComponent.Alignment.END);
            addButton.addClassName("card-button-small");

            productLayout.addAndExpand(productImage, productNameLabel, productPriceField, addButton);
            menuLayout.add(productLayout);
        }

        menuLayout.setVisible(false);
        detailsLayout.setVisible(false);
        commentsLayout.setVisible(false);

        menuButton.addClassName("card-button");
        menuButton.addClickListener(onClick -> menuLayout.setVisible(!menuLayout.isVisible()));
        detailsButton.addClassName("card-button");
        detailsButton.addClickListener(onClick -> detailsLayout.setVisible(!detailsLayout.isVisible()));
        commentsButton.addClassName("card-button");
        commentsButton.addClickListener(onClick -> commentsLayout.setVisible(!commentsLayout.isVisible()));

        actionsLayout.add(menuButton, detailsButton, commentsButton);

        add(imageLayout, infoLayout, menuLayout, detailsLayout, commentsLayout, actionsLayout);
    }

}
