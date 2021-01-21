package be.fooda.frontend.views.searchfood;

import be.fooda.frontend.components.ProductSearchLayout;
import be.fooda.frontend.models.product.Product;
import be.fooda.frontend.service.ProductService;
import be.fooda.frontend.views.main.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@Route(value = "search_food", layout = MainView.class)
@PageTitle("Search Food")
public class SearchFoodView extends VerticalLayout {

    private final ProductService productService;

    private final HorizontalLayout searchLayout = new HorizontalLayout();
    private final TextField searchField = new TextField();
    private final Button searchButton = new Button();

    public SearchFoodView(ProductService productService) {
        this.productService = productService;
        setId("search-food-view");

        setPadding(false);
        setMargin(false);
        setAlignItems(Alignment.AUTO);

        searchLayout.setPadding(false);
        searchLayout.setMargin(false);

        searchField.setAutofocus(true);

        searchButton.setText("Search by Name");
        searchButton.addClickListener(onClick -> {
            searchProductByName(this.searchField.getValue());
        });

        searchLayout.setWidthFull();

        searchLayout.add(searchField, searchButton);
        add(searchLayout);
    }

    private void searchProductByName(String productName) {
        final ResponseEntity<Product[]> responseEntity = productService.searchByName(productName, 1, 10);
        initProductsFromResponse(responseEntity);
    }

    private void initProductsFromResponse(ResponseEntity<Product[]> responseEntity) {
        if (!responseEntity.getStatusCode().equals(HttpStatus.SERVICE_UNAVAILABLE) && responseEntity.getBody() != null) {
            final Product[] products = responseEntity.getBody();
            for (Product product : products) {
                add(new ProductSearchLayout(product));
            }
        }
    }


}
