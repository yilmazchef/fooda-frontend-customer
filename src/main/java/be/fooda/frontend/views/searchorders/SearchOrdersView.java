package be.fooda.frontend.views.searchorders;

import be.fooda.frontend.components.OrderLayout;
import be.fooda.frontend.models.order.Order;
import be.fooda.frontend.service.OrderService;
import be.fooda.frontend.views.main.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Route(value = "search_orders", layout = MainView.class)
@PageTitle("Search Orders")
public class SearchOrdersView extends VerticalLayout {

    private final OrderService orderService;

    private final HorizontalLayout searchLayout = new HorizontalLayout();
    private final TextField firstNameField = new TextField();
    private final TextField familyNameField = new TextField();
    private final Button searchButton = new Button();

    public SearchOrdersView(OrderService orderService) {
        this.orderService = orderService;
        setId("search-orders-view");

        setPadding(false);
        setMargin(false);
        setAlignItems(FlexComponent.Alignment.AUTO);

        searchLayout.setPadding(false);
        searchLayout.setMargin(false);

        firstNameField.setAutofocus(true);

        searchButton.setText("Search by Customer");
        searchButton.addClickListener(onClick -> {
            searchByCustomer(this.firstNameField.getValue(), this.familyNameField.getValue());
        });

        searchLayout.setWidthFull();

        searchLayout.add(firstNameField, familyNameField, searchButton);
        add(searchLayout);


    }

    private void searchByCustomer(String firstName, String familyName) {
        final ResponseEntity<Order[]> responseEntity = orderService.searchByCustomer(firstName, familyName, 1, 10, true);
        initProductsFromResponse(responseEntity);
    }

    private void initProductsFromResponse(ResponseEntity<Order[]> responseEntity) {
        if (!responseEntity.getStatusCode().equals(HttpStatus.SERVICE_UNAVAILABLE) && responseEntity.getBody() != null) {
            final Order[] products = responseEntity.getBody();
            for (Order order : products) {
                add(new OrderLayout(order));
            }
        }
    }

}
