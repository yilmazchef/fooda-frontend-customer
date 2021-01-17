package be.fooda.frontend.views.restaurantmenu;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import be.fooda.frontend.views.main.MainView;

@Route(value = "restaurant_menu", layout = MainView.class)
@PageTitle("Restaurant Menu")
public class RestaurantMenuView extends Div {

    public RestaurantMenuView() {
        setId("restaurant-menu-view");
        add(new Text("Content placeholder"));
    }

}
