package be.fooda.frontend.views.searchrestaurant;

import be.fooda.frontend.components.StoreLayout;
import be.fooda.frontend.models.store.Store;
import be.fooda.frontend.service.BasketService;
import be.fooda.frontend.service.StoreService;
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

@Route(value = "search_restaurant", layout = MainView.class)
@PageTitle("Search Restaurant")
public class SearchRestaurantView extends VerticalLayout {

    private final StoreService storeService;
    private final BasketService basketService;

    private final HorizontalLayout searchLayout = new HorizontalLayout();
    private final TextField searchField = new TextField();
    private final Button searchButton = new Button();


    public SearchRestaurantView(StoreService storeService, BasketService basketService) {
        this.storeService = storeService;
        this.basketService = basketService;
        setId("search-restaurant-view");

        setPadding(false);
        setMargin(false);
        setAlignItems(FlexComponent.Alignment.AUTO);

        searchLayout.setPadding(false);
        searchLayout.setMargin(false);

        searchField.setAutofocus(true);

        searchButton.setText("Search by Name");
        searchButton.addClickListener(onClick -> {
            searchProductByName(this.searchField.getValue());
        });

        searchLayout.setWidthFull();

        searchLayout.add(searchField, searchButton);
        add(searchLayout);

    }

    private void searchProductByName(String productName) {
        final ResponseEntity<Store[]> responseEntity = storeService.searchByStoreName(productName, 1, 10);
        initProductsFromResponse(responseEntity);
    }

    private void initProductsFromResponse(ResponseEntity<Store[]> responseEntity) {
        if (!responseEntity.getStatusCode().equals(HttpStatus.SERVICE_UNAVAILABLE) && responseEntity.getBody() != null) {
            if (responseEntity.getStatusCode().equals(HttpStatus.FOUND)) {
                Store[] stores = responseEntity.getBody();
                if (stores != null && stores.length > 0) {
                    for (Store store : stores) {
                        add(new StoreLayout(store));
                    }
                }
            }
        }
    }

}
