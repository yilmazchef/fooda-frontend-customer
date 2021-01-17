package be.fooda.frontend.views.searchmap;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import be.fooda.frontend.views.main.MainView;

@Route(value = "search_map", layout = MainView.class)
@PageTitle("Search Map")
public class SearchMapView extends Div {

    public SearchMapView() {
        setId("search-map-view");
        add(new Text("Content placeholder"));
    }

}
