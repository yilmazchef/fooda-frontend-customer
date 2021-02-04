package be.fooda.frontend.view;

import be.fooda.frontend.service.BasketService;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "basket/products", layout = MainView.class)
@PageTitle("Fooda | Basket Products")
public class BasketView extends VerticalLayout {

    private final BasketService basketService;

    public BasketView(BasketService basketService) {
        this.basketService = basketService;
        addClassName("page");

        add(new Text("Basket Page.."));

    }
}
