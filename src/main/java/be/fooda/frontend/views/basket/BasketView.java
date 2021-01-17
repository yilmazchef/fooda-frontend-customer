package be.fooda.frontend.views.basket;

import be.fooda.frontend.views.main.MainView;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "basket", layout = MainView.class)
@PageTitle("View Basket")
public class BasketView extends Div {

    public BasketView() {
        setId("basket-view");
        add(new Text("Basket Items .."));
    }

}
