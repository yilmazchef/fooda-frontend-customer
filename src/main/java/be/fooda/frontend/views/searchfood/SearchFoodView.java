package be.fooda.frontend.views.searchfood;

import be.fooda.frontend.models.product.Product;
import be.fooda.frontend.service.ProductService;
import be.fooda.frontend.views.main.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static com.vaadin.flow.component.notification.Notification.Position.BOTTOM_CENTER;

@Route(value = "search_food", layout = MainView.class)
@PageTitle("Search Food")
public class SearchFoodView extends Div {

    private final ProductService productService;

    public SearchFoodView(final ProductService productService) {
        this.productService = productService;

        setId("search-food-view");

        HorizontalLayout searchLayout = new HorizontalLayout();

        TextField searchField = new TextField();
        searchField.setAutofocus(true);
        searchLayout.setFlexGrow(2, searchField);
        Button searchButton = new Button("Search");
        searchButton.addClickListener(click -> searchProducts(1, 10));
        searchLayout.setFlexGrow(0.5, searchButton);
        searchLayout.setWidthFull();

        searchLayout.add(searchField, searchButton);
        add(searchLayout);

    }

    private void searchProducts(int page, int size) {
        ResponseEntity<Product[]> responseEntity = productService.getAll(page, size);

        if (responseEntity.getStatusCode().equals(HttpStatus.FOUND)) {

            Product[] products = responseEntity.getBody();

            for (Product product : Objects.requireNonNull(products)) {
                HorizontalLayout productLayout = new HorizontalLayout();
                productLayout.setWidthFull();

                VerticalLayout productImageLayout = new VerticalLayout();
                Image image = new Image(product.getImages().get(0).getUrl(), product.getProductName());
                image.addClassName("product_image");
                productImageLayout.add(image);
                productLayout.setFlexGrow(1, productImageLayout);
                productImageLayout.setWidthFull();

                VerticalLayout productInfoLayout = new VerticalLayout();
                productInfoLayout.add(new Label(product.getProductName()));
                productLayout.setFlexGrow(2, productInfoLayout);
                productInfoLayout.setWidthFull();

                productLayout.add(productImageLayout, productInfoLayout);
                add(productLayout);
            }
        } else {
            new Notification("No Products found", 3000, BOTTOM_CENTER).open();
        }
    }

}
