package be.fooda.frontend.view;

import be.fooda.frontend.service.StoreService;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "restaurants", layout = MainView.class)
@PageTitle("Fooda | Restaurants")
public class RestaurantsView extends VerticalLayout {

    private final StoreService storeService;

    public RestaurantsView(StoreService storeService) {
        this.storeService = storeService;

        add(new Text("Restaurants Page.."));



    }
}
