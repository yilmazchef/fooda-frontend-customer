package be.fooda.frontend.views.searchfoodfilter;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import be.fooda.frontend.views.main.MainView;

@Route(value = "search_food_filter", layout = MainView.class)
@PageTitle("Search Food Filter")
public class SearchFoodFilterView extends Div {

    public SearchFoodFilterView() {
        setId("search-food-filter-view");
        add(new Text("Content placeholder"));
    }

}
