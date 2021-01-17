package be.fooda.frontend.views.fooddetails;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import be.fooda.frontend.views.main.MainView;

@Route(value = "food_details", layout = MainView.class)
@PageTitle("Food Details")
public class FoodDetailsView extends Div {

    public FoodDetailsView() {
        setId("food-details-view");
        add(new Text("Content placeholder"));
    }

}
