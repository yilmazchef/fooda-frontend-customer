package be.fooda.frontend.views.searchorderdetails;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import be.fooda.frontend.views.main.MainView;

@Route(value = "search_order_details", layout = MainView.class)
@PageTitle("Search Order Details")
public class SearchOrderDetailsView extends Div {

    public SearchOrderDetailsView() {
        setId("search-order-details-view");
        add(new Text("Content placeholder"));
    }

}
