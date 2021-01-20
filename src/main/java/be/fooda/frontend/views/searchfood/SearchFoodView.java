package be.fooda.frontend.views.searchfood;

import be.fooda.frontend.models.product.Product;
import be.fooda.frontend.models.product.ProductCategory;
import be.fooda.frontend.service.ProductService;
import be.fooda.frontend.views.main.MainView;
import com.github.appreciated.card.Card;
import com.github.appreciated.card.action.ActionButton;
import com.github.appreciated.card.action.Actions;
import com.github.appreciated.card.content.IconItem;
import com.github.appreciated.card.content.Item;
import com.github.appreciated.card.label.PrimaryLabel;
import com.github.appreciated.card.label.SecondaryLabel;
import com.github.appreciated.card.label.TitleLabel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.stream.Collectors;

@Route(value = "search_food", layout = MainView.class)
@PageTitle("Search Food")
public class SearchFoodView extends VerticalLayout {

    private final ProductService productService;

    private static final int RESULTS_PER_PAGE = 25;
    private static final int DEFAULT_PAGE_NUMBER = 1;

    private final HorizontalLayout searchLayout = new HorizontalLayout();
    private final TextField searchField = new TextField();
    private final Button searchButton = new Button();

    public SearchFoodView(ProductService productService) {
        this.productService = productService;

        setId("search-food-view");

        setPadding(false);
        setMargin(false);
        setAlignItems(FlexComponent.Alignment.CENTER);

        searchLayout.setPadding(false);
        searchLayout.setMargin(false);

        searchField.setAutofocus(true);

        searchButton.setText("Search by Name");
        searchButton.addClickListener(onClick -> {
            searchProductByName(this.searchField.getValue());
        });

        searchLayout.setFlexGrow(0.5, searchButton);
        searchLayout.setWidthFull();

        searchLayout.add(searchField, searchButton);
        add(searchLayout);
    }

    private void searchProductByName(String productName) {
        final ResponseEntity<Product[]> responseEntity = productService.searchByName(productName, DEFAULT_PAGE_NUMBER, RESULTS_PER_PAGE);
        initProductsFromResponse(responseEntity);
    }

    private void getAllProducts() {
        final ResponseEntity<Product[]> responseEntity = productService.getAll(DEFAULT_PAGE_NUMBER, RESULTS_PER_PAGE);
        initProductsFromResponse(responseEntity);
    }

    private void initProductsFromResponse(ResponseEntity<Product[]> responseEntity) {
        if (!responseEntity.getStatusCode().equals(HttpStatus.SERVICE_UNAVAILABLE) && responseEntity.getBody() != null) {
            final Product[] products = responseEntity.getBody();
            Arrays.stream(products).forEachOrdered(product -> add(new ProductCard(product)));
        }
    }

    public class ProductCard extends VerticalLayout {
        public ProductCard(Product product) {

            Image image = new Image(product.getImages().get(0).getUrl(), product.getProductName());
            image.setWidth("25%");
            image.setHeight("auto");
            Card card = new Card(
                    new IconItem(image, product.getProductName(), product.getDescription()),
                    new Actions(
                            new ActionButton("Action 1", event -> {/* Handle Action*/}),
                            new ActionButton("Action 2", event -> {/* Handle Action*/})
                    )
            );
            card.setWidth("100%");
            add(card);
        }
    }

    public class ProductCardAdvanced extends VerticalLayout {

        public ProductCardAdvanced(Product product) {
            final TitleLabel titleLabel = new TitleLabel(product.getProductName());
            final PrimaryLabel primaryLabel = new PrimaryLabel(product.getDescription());
            final SecondaryLabel secondaryLabel = new SecondaryLabel(product.getCategories().stream().map(ProductCategory::getTitle).collect(Collectors.joining()));
            final IconItem iconItem = new IconItem(VaadinIcon.CART.create(), "Icon Item title", "Icon Item description");
            final Item item = new Item("Item title", "Item description");
            final Image image = new Image(product.getImages().get(0).getUrl(), product.getProductName());
            image.setWidth("25%");
            image.setHeight("auto");

            Card card = new Card(
                    // if you don't want the title to wrap you can set the whitespace = nowrap
                    titleLabel.withWhiteSpaceNoWrap(),
                    primaryLabel,
                    secondaryLabel,
                    iconItem,
                    item,
                    image,
                    new Actions(
                            new ActionButton("Action 1", event -> {/* Handle Action*/}),
                            new ActionButton("Action 2", event -> {/* Handle Action*/})
                    )
            );
            card.setWidth("100%");
            add(card);
        }
    }


}
