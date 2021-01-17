package be.fooda.frontend.views.restaurantmenuitemdetails;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import be.fooda.frontend.views.main.MainView;

@Route(value = "restaurant_menu_item_details", layout = MainView.class)
@PageTitle("Restaurant Menu Item Details")
public class RestaurantMenuItemDetailsView extends Div {

    public RestaurantMenuItemDetailsView() {
        setId("restaurant-menu-item-details-view");
        add(new Text("Content placeholder"));
    }

}
