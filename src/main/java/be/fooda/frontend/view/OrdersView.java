package be.fooda.frontend.view;

import be.fooda.frontend.service.OrderService;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "orders", layout = MainView.class)
@PageTitle("Fooda | Orders")
public class OrdersView extends VerticalLayout {

    private final OrderService orderService;

    public OrdersView(OrderService orderService) {
        this.orderService = orderService;

        add(new Text("Orders Page.."));

    }
}
