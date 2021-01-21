package be.fooda.frontend.views.searchrestaurant;

import be.fooda.frontend.components.StoreCardLayout;
import be.fooda.frontend.models.store.Store;
import be.fooda.frontend.service.StoreService;
import be.fooda.frontend.views.main.MainView;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.http.ResponseEntity;

@Route(value = "search_restaurant", layout = MainView.class)
@PageTitle("Search Restaurant")
public class SearchRestaurantView extends Div {

    private final StoreService storeService;

    public SearchRestaurantView(StoreService storeService) {
        this.storeService = storeService;
        setId("search-restaurant-view");

        final ResponseEntity<Store[]> apiResponse = storeService.getAllStores(1, 5);
        if (apiResponse.getStatusCode().is2xxSuccessful()) {
            Store[] stores = apiResponse.getBody();
            if (stores != null && stores.length > 0) {
                for (Store store : stores) {
                    add(new StoreCardLayout(store));
                }
            }
        }

    }

}
