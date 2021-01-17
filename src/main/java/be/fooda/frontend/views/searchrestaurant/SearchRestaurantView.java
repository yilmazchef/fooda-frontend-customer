package be.fooda.frontend.views.searchrestaurant;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import be.fooda.frontend.views.main.MainView;

@Route(value = "search_restaurant", layout = MainView.class)
@PageTitle("Search Restaurant")
public class SearchRestaurantView extends Div {

    public SearchRestaurantView() {
        setId("search-restaurant-view");
        add(new Text("Content placeholder"));
    }

}
