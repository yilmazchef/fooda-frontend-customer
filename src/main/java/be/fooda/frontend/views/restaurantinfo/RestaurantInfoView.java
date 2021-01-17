package be.fooda.frontend.views.restaurantinfo;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import be.fooda.frontend.views.main.MainView;

@Route(value = "restaurant_info", layout = MainView.class)
@PageTitle("Restaurant Info")
public class RestaurantInfoView extends Div {

    public RestaurantInfoView() {
        setId("restaurant-info-view");
        add(new Text("Content placeholder"));
    }

}
