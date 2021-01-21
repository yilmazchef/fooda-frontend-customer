package be.fooda.frontend.views.mainmenu;

import be.fooda.frontend.components.ProductCategoriesLayout;
import be.fooda.frontend.components.ProductLayout;
import be.fooda.frontend.models.product.Product;
import be.fooda.frontend.models.product.ProductCategory;
import be.fooda.frontend.service.ProductService;
import be.fooda.frontend.service.StoreService;
import be.fooda.frontend.views.main.MainView;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Route(value = "main", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
@PageTitle("Fooda | Main Menu")
public class MainMenuView extends VerticalLayout {

    private final ProductService productService;
    private final StoreService storeService;

    public MainMenuView(ProductService productService, StoreService storeService) {
        this.productService = productService;
        this.storeService = storeService;
        setId("main-menu-view");

        final ResponseEntity<ProductCategory[]> categories = productService.getAllCategories();
        convertApiResponseToCategoryComponents(categories);

        final ResponseEntity<Product[]> responseEntity = productService.getAll(1, 3);
        convertApiResponseToProductComponents(responseEntity);


    }

    private void convertApiResponseToProductComponents(ResponseEntity<Product[]> responseEntity) {
        if (!responseEntity.getStatusCode().equals(HttpStatus.SERVICE_UNAVAILABLE) && responseEntity.getBody() != null) {
            final Product[] products = responseEntity.getBody();
            for (Product product : products) {
                add(new ProductLayout(product));
            }
        }
    }

    private void convertApiResponseToCategoryComponents(ResponseEntity<ProductCategory[]> responseEntity) {
        if (!responseEntity.getStatusCode().equals(HttpStatus.SERVICE_UNAVAILABLE) && responseEntity.getBody() != null) {
            Set<ProductCategory> categories = new HashSet<>(Arrays.asList(responseEntity.getBody()));
            add(new ProductCategoriesLayout(categories));
        }
    }


}
