package be.fooda.frontend.view;

import be.fooda.frontend.layout.ProductGrid;
import be.fooda.frontend.layout.StoreGrid;
import be.fooda.frontend.model.product.Product;
import be.fooda.frontend.model.store.Store;
import be.fooda.frontend.service.BasketService;
import be.fooda.frontend.service.ProductService;
import be.fooda.frontend.service.StoreService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.springframework.http.ResponseEntity;

@Route(value = "home", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
@PageTitle("Fooda | Home")
public class HomeView extends VerticalLayout {

    private final ProductService productService;
    private final StoreService storeService;
    private final BasketService basketService;

    public HomeView(ProductService productService, StoreService storeService, BasketService basketService) {
        this.productService = productService;
        this.storeService = storeService;
        this.basketService = basketService;
        addClassName("page");

        final ResponseEntity storeServiceResponse = storeService.getAllStores(1, 5);
        if ((storeServiceResponse.getStatusCode().is2xxSuccessful() || storeServiceResponse.getStatusCode().is3xxRedirection()) && storeServiceResponse.hasBody())
            add(new StoreGrid((Store[]) storeServiceResponse.getBody()));

        final ResponseEntity productServiceResponse = productService.getAll(1, 10);
        if ((productServiceResponse.getStatusCode().is2xxSuccessful() || productServiceResponse.getStatusCode().is3xxRedirection()) && productServiceResponse.hasBody())
            add(new ProductGrid((Product[]) productServiceResponse.getBody()));



    }
}
