package be.fooda.frontend.views.mainmenu;

import be.fooda.frontend.components.ProductSearchLayout;
import be.fooda.frontend.components.ProductCategoriesLayout;
import be.fooda.frontend.models.product.Product;
import be.fooda.frontend.models.product.ProductCategory;
import be.fooda.frontend.service.ProductService;
import be.fooda.frontend.views.main.MainView;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Route(value = "main", layout = MainView.class)
@PageTitle("Fooda | Main Menu")
public class MainMenuView extends VerticalLayout {

    private ProductService productService;

    public MainMenuView(ProductService productService) {
        this.productService = productService;
        setId("main-menu-view");

        getProductCategoriesFromApi();
        getProductsFromApi();
    }

    private void getProductCategoriesFromApi() {
        final ResponseEntity<ProductCategory[]> categories = productService.getAllCategories();
        initProductCategoriesFromResponse(categories);
    }

    private void getProductsFromApi() {
        final ResponseEntity<Product[]> responseEntity = productService.getAll(1, 2);
        ConvertApiResponseToComponent(responseEntity);
    }

    private void ConvertApiResponseToComponent(ResponseEntity<Product[]> responseEntity) {
        if (!responseEntity.getStatusCode().equals(HttpStatus.SERVICE_UNAVAILABLE) && responseEntity.getBody() != null) {
            final Product[] products = responseEntity.getBody();
            for (Product product : products) {
                add(new ProductSearchLayout(product));
            }
        }
    }

    private void initProductCategoriesFromResponse(ResponseEntity<ProductCategory[]> responseEntity) {
        if (!responseEntity.getStatusCode().equals(HttpStatus.SERVICE_UNAVAILABLE) && responseEntity.getBody() != null) {
            Set<ProductCategory> categories = new HashSet<>(Arrays.asList(responseEntity.getBody()));
            add(new ProductCategoriesLayout(categories));
        }
    }


}
