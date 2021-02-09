package be.fooda.frontend.view;

import be.fooda.frontend.layout.StoreLayout;
import be.fooda.frontend.model.store.Store;
import be.fooda.frontend.service.StoreService;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyModifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Route(value = "restaurants", layout = MainView.class)
@PageTitle("Fooda | Restaurants")
public class RestaurantsView extends VerticalLayout {

    private final StoreService storeService;

    private final HorizontalLayout searchLayout = new HorizontalLayout();
    private final TextField searchField = new TextField();
    private final Button searchButton = new Button(VaadinIcon.SEARCH.create());
    private final Button addCriteriaButton = new Button(VaadinIcon.PLUS_CIRCLE_O.create());
    private final Button clearCriteriaButton = new Button(VaadinIcon.ERASER.create());

    private final HorizontalLayout criteriaLayout = new HorizontalLayout();
    private final Paragraph criteriaSetP = new Paragraph();

    private final VerticalLayout storesLayout = new VerticalLayout();

    public RestaurantsView(StoreService storeService) {
        this.storeService = storeService;
        addClassName("page");
        searchLayout.addClassName("search-box");

        addCriteriaButton.addClickListener(onAddCriteria -> {
            if (!searchField.getValue().isEmpty()) {
                final String hashTagValue = " #" + searchField.getValue();
                criteriaSetP.setText(criteriaSetP.getText() + hashTagValue);
                searchField.focus();
            }
        });
        addCriteriaButton.addClickShortcut(Key.ENTER);

        criteriaLayout.add(criteriaSetP);

        clearCriteriaButton.addClickListener(onClearClick -> {
            criteriaSetP.setText("");
        });

        searchField.focus();
        searchField.setClearButtonVisible(true);

        searchButton.setIconAfterText(true);
        searchButton.addClickListener(onSearchClick -> {

            storesLayout.removeAll();

            if (!criteriaSetP.getText().isEmpty()) {

                final String[] keywords = Arrays
                        .stream(criteriaSetP.getText().split("#"))
                        .map(keyword -> keyword.replace("#", "").trim().toLowerCase(Locale.ROOT))
                        .distinct()
                        .toArray(String[]::new);

                List<Store> searchResults = new ArrayList<>();
                for (String keyword : keywords) {
                    if (!keyword.isEmpty()) {
                        final ResponseEntity searchResponse = storeService.searchByStoreName(keyword, 1, 25);
                        if (searchResponse.getStatusCode().equals(HttpStatus.FOUND) && searchResponse.hasBody()) {
                            Store[] searchResultsByKeyword = (Store[]) searchResponse.getBody();
                            if (searchResultsByKeyword != null) {
                                searchResults.addAll(Arrays.asList(searchResultsByKeyword));
                            }
                        } else {
                            new Notification("Nothing is found with this search..", 2000, Notification.Position.BOTTOM_CENTER).open();
                        }
                    }
                }

                Store[] searchResultsWithDuplicatesRemoved = searchResults.stream().distinct().toArray(Store[]::new);

                for (Store store : searchResultsWithDuplicatesRemoved) {
                    storesLayout.add(new StoreLayout(store));
                }
            }
        });
        searchButton.addClickShortcut(Key.ENTER, KeyModifier.ALT);

        searchLayout.add(searchField, addCriteriaButton, clearCriteriaButton, searchButton);


        //        START -> PRODUCTS LAYOUT COMPONENTS

        final ResponseEntity response = storeService.getAllStores(1, 10);
        Store[] stores = (Store[]) response.getBody();

        if (response.getStatusCode().equals(HttpStatus.FOUND) && stores != null && stores.length > 0) {
            for (Store store : stores) {
                storesLayout.add(new StoreLayout(store));
            }
        }

//        END -> PRODUCTS LAYOUT COMPONENTS

        add(searchLayout, criteriaLayout, storesLayout);

    }
}
