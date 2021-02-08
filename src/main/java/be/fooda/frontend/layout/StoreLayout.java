package be.fooda.frontend.layout;

import be.fooda.frontend.model.store.Product;
import be.fooda.frontend.model.store.Store;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.io.Serializable;
import java.util.List;

@Tag("vaadin-store-layout")
public class StoreLayout extends Component implements HasComponents, HasStyle, Serializable {

    private final VerticalLayout imageLayout = new VerticalLayout();
    private final Image storeImg = new Image();

    private final VerticalLayout infoLayout = new VerticalLayout();
    private final H2 storeNameH2 = new H2();
    private final Paragraph storeDescriptionP = new Paragraph();

    private final HorizontalLayout menuLayout = new HorizontalLayout();
    private final Grid<Product> menuGrid = new Grid<>(Product.class, false);

    private final HorizontalLayout detailsLayout = new HorizontalLayout();

    private final HorizontalLayout commentsLayout = new HorizontalLayout();

    private final HorizontalLayout actionsLayout = new HorizontalLayout();
    private final Button menuButton = new Button("Menu");
    private final Button detailsButton = new Button("Details");
    private final Button commentsButton = new Button("Comments");

    public StoreLayout(Store data) {

//        START -> INFO LAYOUT COMPONENTS

        storeImg.setSrc(data.getBgImage().getUrl());
        storeImg.setAlt(data.getName());
        storeImg.addClassName("image");
        imageLayout.add(storeImg);

        storeNameH2.setText(data.getName());
        storeNameH2.addClassName("name");
        storeDescriptionP.setText(data.getAbout());
        storeDescriptionP.addClassName("description");
        infoLayout.add(storeNameH2, storeDescriptionP);

//        START -> INFO LAYOUT COMPONENTS

//        START -> MENU LAYOUT COMPONENTS

        List<Product> products = data.getProducts();


        menuGrid.addColumn(Product::getName).setHeader("Name");
        menuGrid.addColumn(Product::getPrice).setHeader("Price");
        menuGrid.addColumn(product -> {
            Button add = new Button(VaadinIcon.CART.create());
            add.addClickListener(onClick -> {
                new Notification(product.getName() + " is added.", 1000, Notification.Position.BOTTOM_CENTER).open();
            });
            return add;
        }).setHeader("Company");
        menuGrid.setItems(products);

        menuLayout.add(menuGrid);
        menuLayout.setVisible(false);

//        END -> MENU LAYOUT COMPONENTS

//        START -> DETAILS LAYOUT COMPONENTS

//        END -> DETAILS LAYOUT COMPONENTS

//        START -> COMMENTS LAYOUT COMPONENTS

//        END -> COMMENTS LAYOUT COMPONENTS

//        START -> ACTIONS LAYOUT COMPONENTS

        menuButton.addClickListener(onClick -> {
            final boolean layoutVisible = menuLayout.isVisible();
            menuLayout.setVisible(!layoutVisible);
        });
        menuButton.addClassName("menu-button");

        detailsButton.addClickListener(onClick -> {
            final boolean layoutVisible = detailsLayout.isVisible();
            detailsButton.setText(layoutVisible ? "Hide Details" : "Details");
            detailsLayout.setVisible(!layoutVisible);
        });
        detailsButton.addClassName("details-button");

        commentsButton.addClickListener(onClick -> {
            final boolean layoutVisible = commentsLayout.isVisible();
            commentsButton.setText(layoutVisible ? "Hide Comments" : "Comments");
            commentsLayout.setVisible(!layoutVisible);
        });
        commentsButton.addClassName("comments-button");

        actionsLayout.add(menuButton, detailsButton, commentsButton);

//        END -> ACTIONS LAYOUT COMPONENTS

        add(imageLayout, infoLayout, menuLayout, actionsLayout);
    }

}
