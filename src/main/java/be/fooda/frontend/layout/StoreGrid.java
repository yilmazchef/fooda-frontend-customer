package be.fooda.frontend.layout;

import be.fooda.frontend.model.store.Store;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.VaadinIcon;

import static be.fooda.frontend.layout.CardStyleDefinitions.CARD_BUTTON_WITH_ICON;

public class StoreGrid extends Grid<Store> {

    public StoreGrid(Store[] data) {

        setItems(data);
        removeAllColumns();

        Image storeLogoImage = new Image();
        addComponentColumn(store -> {
            storeLogoImage.setSrc(store.getBgImage().getUrl());
            storeLogoImage.setAlt(store.getName());
            storeLogoImage.setWidth("50px");
            storeLogoImage.setHeight("auto");
            storeLogoImage.setMaxWidth("75px");
            return storeLogoImage;
        });

        addColumn(Store::getName).setHeader("Store Name");
        addColumn(store -> store.getAddress().getPostcode()).setHeader("Postcode");

        Button menuButton = new Button(VaadinIcon.CUTLERY.create());
        Button detailsButton = new Button(VaadinIcon.CHART_GRID.create());
        Button commentsButton = new Button(VaadinIcon.COMMENTS_O.create());
        menuButton.addClassName(CARD_BUTTON_WITH_ICON.getValue());
        detailsButton.addClassName(CARD_BUTTON_WITH_ICON.getValue());
        commentsButton.addClassName(CARD_BUTTON_WITH_ICON.getValue());

        addComponentColumn(store -> {
            menuButton.addClickListener(onClick -> {
                UI.getCurrent().navigate("/restaurant/menu/" + store.getId());
            });
            return menuButton;
        }).setHeader("Menu");

        addComponentColumn(store -> {
            detailsButton.addClickListener(onClick -> {
                UI.getCurrent().navigate("/restaurant/details/" + store.getId());
            });
            return detailsButton;
        }).setHeader("Menu");

        addComponentColumn(store -> {
            commentsButton.addClickListener(onClick -> {
                UI.getCurrent().navigate("/restaurant/comments/" + store.getId());
            });
            return commentsButton;
        }).setHeader("Menu");

        getColumns().forEach(col -> col.setAutoWidth(true));
        setVerticalScrollingEnabled(true);
        getStyle().set("margin-bottom", "15px");
    }
}
