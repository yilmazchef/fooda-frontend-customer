package be.fooda.frontend.views.restaurantcomments;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import be.fooda.frontend.views.main.MainView;

@Route(value = "restaurant_comments", layout = MainView.class)
@PageTitle("Restaurant Comments")
public class RestaurantCommentsView extends Div {

    public RestaurantCommentsView() {
        setId("restaurant-comments-view");
        add(new Text("Content placeholder"));
    }

}
