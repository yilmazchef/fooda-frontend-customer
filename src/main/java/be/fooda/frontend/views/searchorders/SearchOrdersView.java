package be.fooda.frontend.views.searchorders;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import be.fooda.frontend.views.main.MainView;

@Route(value = "search_orders", layout = MainView.class)
@PageTitle("Search Orders")
public class SearchOrdersView extends Div {

    public SearchOrdersView() {
        setId("search-orders-view");
        add(new Text("Content placeholder"));
    }

}
