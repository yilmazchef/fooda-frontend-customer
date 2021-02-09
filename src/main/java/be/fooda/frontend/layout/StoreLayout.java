package be.fooda.frontend.layout;

import be.fooda.frontend.mapper.ProductMapper;
import be.fooda.frontend.model.product.Product;
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

import static be.fooda.frontend.layout.CardStyleDefinitions.*;

@Tag("vaadin-store-layout")
public class StoreLayout extends Component implements HasComponents, HasStyle, Serializable {

    private final VerticalLayout imageLayout = new VerticalLayout();
    private final Image storeImg = new Image();

    private final VerticalLayout infoLayout = new VerticalLayout();
    private final H2 storeNameH2 = new H2();
    private final Paragraph storeDescriptionP = new Paragraph();

    private final VerticalLayout menuLayout = new VerticalLayout();
    private final Grid<Product> productGrid = new Grid<>(Product.class);

    private final VerticalLayout detailsLayout = new VerticalLayout();
    private final VerticalLayout commentsLayout = new VerticalLayout();

    private final HorizontalLayout actionsLayout = new HorizontalLayout();
    private final Button menuButton = new Button(VaadinIcon.CUTLERY.create());
    private final Button detailsButton = new Button(VaadinIcon.CHART_GRID.create());
    private final Button commentsButton = new Button(VaadinIcon.COMMENTS_O.create());

    private final ProductMapper mapper = new ProductMapper();

    public StoreLayout(Store data) {

        addClassName(CARD.getValue());

        storeImg.setSrc(data.getBgImage().getUrl());
        storeImg.setAlt(data.getName());
        storeImg.addClassName(CARD_IMAGE.getValue());
        imageLayout.add(storeImg);

        storeNameH2.setText(data.getName());
        storeNameH2.addClassName(CARD_TITLE.getValue());
        storeDescriptionP.setText(data.getAbout());
        storeDescriptionP.addClassName(CARD_DESCRIPTION.getValue());
        infoLayout.add(storeNameH2, storeDescriptionP);

        Product[] products = new Product[data.getProducts().size()];
        List<be.fooda.frontend.model.store.Product> dataProducts = data.getProducts();
        for (int i = 0; i < dataProducts.size(); i++) {
            be.fooda.frontend.model.store.Product product = dataProducts.get(i);
            Product toProduct = mapper.map(product);
            products[i] = toProduct;
        }

        initProductGrid(products);
        menuLayout.add(productGrid);

        menuLayout.setVisible(false);
        detailsLayout.setVisible(false);
        commentsLayout.setVisible(false);

        menuButton.addClassName(CARD_BUTTON_WITH_ICON.getValue());
        menuButton.addClickListener(onClick -> menuLayout.setVisible(!menuLayout.isVisible()));
        detailsButton.addClassName(CARD_BUTTON_WITH_ICON.getValue());
        detailsButton.addClickListener(onClick -> detailsLayout.setVisible(!detailsLayout.isVisible()));
        commentsButton.addClassName(CARD_BUTTON_WITH_ICON.getValue());
        commentsButton.addClickListener(onClick -> commentsLayout.setVisible(!commentsLayout.isVisible()));

        actionsLayout.add(menuButton, detailsButton, commentsButton);

        add(imageLayout, infoLayout, menuLayout, detailsLayout, commentsLayout, actionsLayout);
    }

    private void initProductGrid(Product[] data) {

        productGrid.setItems(data);
        productGrid.removeAllColumns();
        productGrid.addColumn(be.fooda.frontend.model.product.Product::getName).setHeader("Product Name");
        productGrid.addColumn(product -> product.getPrices().get(0).getAmount()).setHeader("Price");

        productGrid.addComponentColumn(product -> {
            final Button addButton = new Button(VaadinIcon.PLUS.create(), onClick -> {
                new Notification(product.getName() + " is added.", 1000, Notification.Position.BOTTOM_CENTER).open();
            });
            addButton.addClassName(CARD_BUTTON_WITH_ICON.getValue());
            return addButton;
        }).setHeader("Add");

        productGrid.getColumns().forEach(col -> col.setAutoWidth(true));
        productGrid.getStyle().set("margin-bottom", "15px");
        productGrid.setVerticalScrollingEnabled(true);
        productGrid.setHeight("100px");
        productGrid.setMaxHeight("500px");
    }

}
