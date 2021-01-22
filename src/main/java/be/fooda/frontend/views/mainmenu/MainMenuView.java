package be.fooda.frontend.views.mainmenu;

import be.fooda.frontend.components.ProductCategoriesLayout;
import be.fooda.frontend.components.ProductLayout;
import be.fooda.frontend.components.StoreLayout;
import be.fooda.frontend.models.product.Product;
import be.fooda.frontend.models.product.ProductCategory;
import be.fooda.frontend.models.store.Store;
import be.fooda.frontend.service.BasketService;
import be.fooda.frontend.service.ProductService;
import be.fooda.frontend.service.StoreService;
import be.fooda.frontend.views.main.MainView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Route(value = "home", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
@PageTitle("Fooda | Main Menu")
public class MainMenuView extends VerticalLayout {

    private final ProductService productService;
    private final StoreService storeService;
    private final BasketService basketService;

    private final be.fooda.frontend.models.user.User sessionUser;

    public MainMenuView(ProductService productService, StoreService storeService, BasketService basketService) {
        this.productService = productService;
        this.storeService = storeService;
        this.basketService = basketService;
        this.sessionUser = UI.getCurrent().getSession().getAttribute(be.fooda.frontend.models.user.User.class);

        setId("main-menu-view");

        if (this.sessionUser != null)
            add(new Label("Current user:" + sessionUser.getLogin()));

        final ResponseEntity<ProductCategory[]> categoriesResponse = productService.getAllCategories();
        convertApiResponseToCategoryComponents(categoriesResponse);

        final ResponseEntity<Product[]> productsResponse = productService.getAll(1, 4);
        convertApiResponseToProductComponents(productsResponse);

        final ResponseEntity<Store[]> storesResponse = storeService.getAllStores(1, 2);
        convertApiResponseToStoreComponents(storesResponse);
    }

    private void convertApiResponseToStoreComponents(ResponseEntity<Store[]> responseEntity) {
        if (responseEntity.getStatusCode().equals(HttpStatus.FOUND)) {
            Store[] stores = responseEntity.getBody();
            if (stores != null && stores.length > 0) {
                for (Store store : stores) {
                    add(new StoreLayout(store));
                }
            }
        }
    }

    private void convertApiResponseToProductComponents(ResponseEntity<Product[]> responseEntity) {
        if (!responseEntity.getStatusCode().equals(HttpStatus.SERVICE_UNAVAILABLE) && responseEntity.getBody() != null) {
            final Product[] products = responseEntity.getBody();
            for (Product product : products) {
                add(new ProductLayout(product, basketService));
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
