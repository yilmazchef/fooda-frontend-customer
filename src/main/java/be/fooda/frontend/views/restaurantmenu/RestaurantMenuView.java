package be.fooda.frontend.views.restaurantmenu;

import be.fooda.frontend.views.main.MainView;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "restaurant_menu", layout = MainView.class)
@PageTitle("Restaurant Menu")
public class RestaurantMenuView extends Div {

    public RestaurantMenuView() {
        setId("restaurant-menu-view");




    }



}
