package be.fooda.frontend.layout;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;

import static be.fooda.frontend.layout.CardStyleDefinitions.CARD_BUTTON_WITH_ICON;

public class ProductGrid extends Grid<be.fooda.frontend.model.product.Product> {

    public ProductGrid(be.fooda.frontend.model.product.Product[] data) {

        setItems(data);
        removeAllColumns();
        addColumn(be.fooda.frontend.model.product.Product::getName).setHeader("Product Name");
        addColumn(product -> product.getPrices().get(0).getAmount()).setHeader("Price");

        addComponentColumn(product -> {
            final Button addButton = new Button(VaadinIcon.PLUS.create(), onClick -> {
                new Notification(product.getName() + " is added.", 1000, Notification.Position.BOTTOM_CENTER).open();
            });
            addButton.addClassName(CARD_BUTTON_WITH_ICON.getValue());
            return addButton;
        }).setHeader("Add");

        getColumns().forEach(col -> col.setAutoWidth(true));
        setVerticalScrollingEnabled(true);
        getStyle().set("margin-bottom", "15px");
    }
}
