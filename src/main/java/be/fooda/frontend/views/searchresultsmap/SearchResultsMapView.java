package be.fooda.frontend.views.searchresultsmap;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import be.fooda.frontend.views.main.MainView;

@Route(value = "search_results_map", layout = MainView.class)
@PageTitle("Search Results Map")
public class SearchResultsMapView extends Div {

    public SearchResultsMapView() {
        setId("search-results-map-view");
        add(new Text("Content placeholder"));
    }

}
