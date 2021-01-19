package be.fooda.frontend.views.searchfood;

import be.fooda.frontend.models.product.Product;
import be.fooda.frontend.service.BasketService;
import be.fooda.frontend.service.ProductService;
import be.fooda.frontend.views.main.MainView;
import com.github.appreciated.card.Card;
import com.github.appreciated.card.action.ActionButton;
import com.github.appreciated.card.action.Actions;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Route(value = "search_food", layout = MainView.class)
@PageTitle("Search Food")
public class SearchFoodView extends VerticalLayout {

    private final ProductService productService;
    private final BasketService basketService;

    private static final int RESULTS_PER_PAGE = 25;
    private static final int DEFAULT_PAGE_NUMBER = 1;

    private final HorizontalLayout searchLayout = new HorizontalLayout();
    private final TextField searchField = new TextField();
    private final Button searchButton = new Button();
    private final VerticalLayout productSearchResultsLayout = new VerticalLayout();

    public SearchFoodView(ProductService productService, BasketService basketService) {
        this.productService = productService;
        this.basketService = basketService;

        setId("search-food-view");

        setPadding(false);
        setMargin(false);
        setAlignItems(FlexComponent.Alignment.CENTER);

        productSearchResultsLayout.setPadding(false);
        productSearchResultsLayout.setMargin(false);
        // this must be visible when product search is started..
        productSearchResultsLayout.setVisible(false);

        searchLayout.setPadding(false);
        searchLayout.setMargin(false);

        searchField.setAutofocus(true);

        searchButton.setText("Search by Name");
        searchButton.addClickListener(onClick -> {
            productSearchResultsLayout.removeAll();
            List<ProductCardLayout> cards = searchProductByName(this.searchField.getValue());
            cards.forEach(productSearchResultsLayout::add);
            productSearchResultsLayout.setVisible(true);
        });

        searchLayout.setFlexGrow(0.5, searchButton);
        searchLayout.setWidthFull();

        searchLayout.add(searchField, searchButton, productSearchResultsLayout);
        add(searchLayout);
    }

    private List<ProductCardLayout> searchProductByName(String productName) {
        final ResponseEntity<Product[]> responseEntity = productService.searchByName(productName, DEFAULT_PAGE_NUMBER, RESULTS_PER_PAGE);
        return initProductsFromResponse(responseEntity);
    }

    private List<ProductCardLayout> getAllProducts() {
        final ResponseEntity<Product[]> responseEntity = productService.getAll(DEFAULT_PAGE_NUMBER, RESULTS_PER_PAGE);
        return initProductsFromResponse(responseEntity);
    }

    private List<ProductCardLayout> initProductsFromResponse(ResponseEntity<Product[]> responseEntity) {
        if (!responseEntity.getStatusCode().equals(HttpStatus.SERVICE_UNAVAILABLE) && responseEntity.getBody() != null) {
            final Product[] products = responseEntity.getBody();
            if (products.length > 0) {
                return Arrays.stream(products).map(product -> {
                    return new ProductCardLayout(
                            product.getImages().get(0).getUrl(),
                            product.getProductName(),
                            product.getDescription(),
                            String.valueOf(product.getLimitPerOrder()),
                            product.getPrices().get(0).getAmount().toPlainString() + " " + product.getPrices().get(0).getCurrency()
                    );
                }).collect(Collectors.toList());
            } else {
                final Notification requiredSmsCodeNotification = new Notification("No Products Found..");
                requiredSmsCodeNotification.getElement().getStyle().set("color", "#FFCC00");
                requiredSmsCodeNotification.setDuration(2000);
                requiredSmsCodeNotification.open();
                return Collections.emptyList();
            }
        }

        return Collections.emptyList();
    }

    public static class ProductCardLayout extends VerticalLayout {

        public ProductCardLayout(String imageUrl, String name, String description) {
            setPadding(false);
            setMargin(false);
            getStyle().set("border-radius", "10px");

            Image defaultImage = new Image(imageUrl, name);
            defaultImage.setWidth("25vw");
            defaultImage.setHeight("auto");

            H3 nameHeader = new H3(name);
            nameHeader.getStyle()
                    .set("color", "rgba(242, 242, 242, 1)")
                    .set("font-size", "14px");

            Span descriptionSpan = new Span(description);

            Card card = new Card(
                    defaultImage, nameHeader, descriptionSpan,
                    new Actions(
                            new ActionButton(VaadinIcon.MINUS.create(), onClick -> {
                                new Notification("Decreased").open();
                            }),
                            new Label("0"),
                            new ActionButton(VaadinIcon.PLUS.create(), onClick -> {
                                new Notification("Increased").open();
                            })
                    )
            );
            card.setWidth("100vw");
            add(card);
        }

        public ProductCardLayout(String imageUrl, String name, String description,
                                 String limitsPerOrder, String totalPricePerProduct) {
            setPadding(false);
            setMargin(false);
            getStyle().set("border-radius", "10px");

            Image defaultImage = new Image(imageUrl, name);
            defaultImage.setWidth("25vw");
            defaultImage.setHeight("auto");

            H3 nameHeader = new H3(name);
            nameHeader.getStyle()
                    .set("color", "rgba(242, 242, 242, 1)")
                    .set("font-size", "14px");

            Span descriptionSpan = new Span(description);

            Span limitsPerOrderSpan = new Span(String.valueOf(limitsPerOrder));
            limitsPerOrderSpan.getStyle().set("font-size", "2em");

            Span totalPricePerProductSpan = new Span(String.valueOf(totalPricePerProduct));
            totalPricePerProductSpan.getStyle().set("font-size", "4em");

            Card card = new Card(
                    defaultImage, nameHeader, descriptionSpan, limitsPerOrderSpan, totalPricePerProductSpan,
                    new Actions(
                            new ActionButton(VaadinIcon.MINUS.create(), onClick -> {
                                new Notification("Decreased").open();
                            }),
                            new Label("0"),
                            new ActionButton(VaadinIcon.PLUS.create(), onClick -> {
                                new Notification("Increased").open();
                            })
                    )
            );
            card.setWidth("100vw");
            add(card);
        }
    }

}
