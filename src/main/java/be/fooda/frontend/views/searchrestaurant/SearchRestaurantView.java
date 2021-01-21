package be.fooda.frontend.views.searchrestaurant;

import be.fooda.frontend.components.StoreCardLayout;
import be.fooda.frontend.models.store.Store;
import be.fooda.frontend.service.StoreService;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import be.fooda.frontend.views.main.MainView;
import org.springframework.http.ResponseEntity;

@Route(value = "search_restaurant", layout = MainView.class)
@PageTitle("Search Restaurant")
public class SearchRestaurantView extends Div {

    private final StoreService storeService;

    public SearchRestaurantView(StoreService storeService) {
        this.storeService = storeService;
        setId("search-restaurant-view");

        add(new Text("Delete this line .. "));

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
