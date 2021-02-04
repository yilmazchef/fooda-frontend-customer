package be.fooda.frontend.view;

import be.fooda.frontend.service.BasketService;
import be.fooda.frontend.service.ProductService;
import be.fooda.frontend.service.StoreService;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

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

        add(new Text("Home Page.."));

    }
}
