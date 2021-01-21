package be.fooda.frontend.views.restaurantinfo;

import be.fooda.frontend.service.StoreService;
import be.fooda.frontend.views.main.MainView;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "restaurant_info", layout = MainView.class)
@PageTitle("Restaurant Info")
public class RestaurantInfoView extends Div {

    private final StoreService storeService;

    public RestaurantInfoView(StoreService storeService) {
        this.storeService = storeService;
        setId("restaurant-info-view");

        

    }

}
