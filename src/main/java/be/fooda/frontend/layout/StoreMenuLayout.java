package be.fooda.frontend.layout;

import be.fooda.frontend.model.store.Store;
import be.fooda.frontend.service.StoreService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Location;
import com.vaadin.flow.router.QueryParameters;
import org.springframework.http.ResponseEntity;

import java.util.*;

public class StoreMenuLayout extends Component implements HasComponents, HasStyle, HasUrlParameter<String> {

    private final Map<String, List<String>> params = new HashMap<>();

    private final StoreService storeService;

    public StoreMenuLayout(StoreService storeService) {
        this.storeService = storeService;

        final ResponseEntity response = storeService.getAllProductsByStoreId(UUID.fromString(params.get("id").get(0)));
        if ((response.getStatusCode().is2xxSuccessful() || response.getStatusCode().is3xxRedirection()) && response.hasBody()) {
            Store store = (Store) response.getBody();
            add(new Text(Objects.requireNonNull(store).getName()));
        }
    }

    /**
     * getQueryParameters() supports multiple values associated with the same key,
     * for example https://example.com/?genre=fiction&restrictions=16+&genre=classic
     * will result in the corresponding map {"genre" : ["fiction", "classic"], "restrictions": ["16+"]}}.
     */
    @Override
    public void setParameter(BeforeEvent beforeEvent, String parameter) {

        Location location = beforeEvent.getLocation();
        QueryParameters queryParameters = location.getQueryParameters();
        params.putAll(queryParameters.getParameters());
    }
}
