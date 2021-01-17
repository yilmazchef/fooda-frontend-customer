package be.fooda.frontend.views.foodimages;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import be.fooda.frontend.views.main.MainView;

@Route(value = "food_images", layout = MainView.class)
@PageTitle("Food Images")
public class FoodImagesView extends Div {

    public FoodImagesView() {
        setId("food-images-view");
        add(new Text("Content placeholder"));
    }

}
