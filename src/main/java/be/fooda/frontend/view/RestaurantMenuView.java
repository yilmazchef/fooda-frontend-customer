package be.fooda.frontend.view;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "restaurant/menu", layout = MainView.class)
@PageTitle("Fooda | Restaurant Menu")
public class RestaurantMenuView extends VerticalLayout {


    public RestaurantMenuView() {
        addClassName("page");

        add(new Text("Basket Page.."));

    }
}
