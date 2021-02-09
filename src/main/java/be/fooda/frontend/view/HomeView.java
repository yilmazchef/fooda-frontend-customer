package be.fooda.frontend.view;

import be.fooda.frontend.model.product.Product;
import be.fooda.frontend.model.store.Store;
import be.fooda.frontend.service.BasketService;
import be.fooda.frontend.service.ProductService;
import be.fooda.frontend.service.StoreService;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyModifier;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.http.ResponseEntity;

import java.util.stream.Collectors;

import static be.fooda.frontend.layout.CardStyleDefinitions.CARD_BUTTON_WITH_ICON;

@Route(value = "home", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
@PageTitle("Fooda | Home")
public class HomeView extends VerticalLayout {

    private final String eUserId = VaadinSession.getCurrent().getSession().getAttribute("eUserId").toString();
    private final String username = VaadinSession.getCurrent().getSession().getAttribute("username").toString();
    private final String session = VaadinSession.getCurrent().getSession().getId();

    private final ProductService productService;
    private final StoreService storeService;
    private final BasketService basketService;

    private final HorizontalLayout searchLayout = new HorizontalLayout();
    private final TextField searchField = new TextField();
    private final Button searchButton = new Button(VaadinIcon.SEARCH.create());

    private final Grid<Product> productGrid = new Grid<>(Product.class);
    private final Grid<Store> storeGrid = new Grid<>(Store.class);

    public HomeView(ProductService productService, StoreService storeService, BasketService basketService) {
        this.productService = productService;
        this.storeService = storeService;
        this.basketService = basketService;
        addClassName("page");

        searchLayout.addClassName("search-box");
        searchButton.addClickShortcut(Key.ENTER, KeyModifier.ALT);
        searchLayout.add(searchField, searchButton);

        final ResponseEntity storeServiceResponse = storeService.getAllStores(1, 5);
        if ((storeServiceResponse.getStatusCode().is2xxSuccessful() || storeServiceResponse.getStatusCode().is3xxRedirection()) && storeServiceResponse.hasBody()) {
            final Store[] data = (Store[]) storeServiceResponse.getBody();
            initStoreGrid(data);
            add(storeGrid);
        }

        final ResponseEntity productServiceResponse = productService.getAll(1, 10);
        if ((productServiceResponse.getStatusCode().is2xxSuccessful() || productServiceResponse.getStatusCode().is3xxRedirection()) && productServiceResponse.hasBody()) {
            final Product[] data = (Product[]) productServiceResponse.getBody();
            initProductGrid(data);
            add(productGrid);
        }

    }

    private void initProductGrid(Product[] data) {

        productGrid.setItems(data);
        productGrid.removeAllColumns();
        productGrid.addColumn(be.fooda.frontend.model.product.Product::getName).setHeader("Product Name");
        productGrid.addColumn(product -> product.getPrices().get(0).getAmount()).setHeader("Price");

        productGrid.addComponentColumn(product -> {
            final Button addButton = new Button(VaadinIcon.PLUS.create(), onClick -> {
                final ResponseEntity addToBasketResponse = basketService.addProduct(mapToBasketProduct(product));
                if (addToBasketResponse.getStatusCode().is2xxSuccessful() || addToBasketResponse.getStatusCode().is3xxRedirection())
                    new Notification(product.getName() + " is added.", 1000, Notification.Position.BOTTOM_CENTER).open();
            });
            addButton.addClassName(CARD_BUTTON_WITH_ICON.getValue());
            return addButton;
        }).setHeader("Add");

        productGrid.getColumns().forEach(col -> col.setAutoWidth(true));
        productGrid.setVerticalScrollingEnabled(true);
        productGrid.getStyle().set("margin-bottom", "15px");
    }

    private be.fooda.frontend.model.basket.Product mapToBasketProduct(Product product) {
        return new be.fooda.frontend.model.basket.Product(
                null,
                product.getId().toString(),
                new be.fooda.frontend.model.basket.User(null, eUserId, username, session),
                new be.fooda.frontend.model.basket.Store(null, product.getStore().geteStoreId().toString(), product.getStore().getName()),
                product.getName(),
                product.getDefaultImage().getUrl(),
                product.getPrices().get(0).getAmount(),
                product.getDescription(),
                1,
                product.getIngredients().stream().map(ingredient ->
                        new be.fooda.frontend.model.basket.Ingredient(null, ingredient.getId().toString(), ingredient.getPrice())).collect(Collectors.toSet())
        );
    }

    private void initStoreGrid(Store[] data) {

        storeGrid.setItems(data);
        storeGrid.removeAllColumns();

        storeGrid.addColumn(Store::getName).setHeader("Store Name");
        storeGrid.addColumn(store -> store.getAddress().getPostcode()).setHeader("Postcode");

        storeGrid.addComponentColumn(store -> {
            Button menuButton = new Button(VaadinIcon.CUTLERY.create());
            menuButton.addClassName(CARD_BUTTON_WITH_ICON.getValue());
            menuButton.addClickListener(onClick -> {
                menuButton.setId("menu_button_store_" + store.getId().toString());
                UI.getCurrent().navigate("restaurant/menu/id=" + store.getId());
            });
            return menuButton;
        }).setHeader("Menu");

        storeGrid.addComponentColumn(store -> {
            Button detailsButton = new Button(VaadinIcon.CHART_GRID.create());
            detailsButton.addClassName(CARD_BUTTON_WITH_ICON.getValue());
            detailsButton.addClickListener(onClick -> {
                detailsButton.setId("details_button_store_" + store.getId().toString());
                UI.getCurrent().navigate("restaurant/details/id=" + store.getId());
            });
            return detailsButton;
        }).setHeader("Details");

        storeGrid.getColumns().forEach(col -> col.setAutoWidth(true));
        storeGrid.setVerticalScrollingEnabled(true);
        storeGrid.getStyle().set("margin-bottom", "15px");
        storeGrid.setHeight("200px");
    }
}
