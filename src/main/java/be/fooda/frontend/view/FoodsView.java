package be.fooda.frontend.view;

import be.fooda.frontend.layout.ProductLayout;
import be.fooda.frontend.model.product.Category;
import be.fooda.frontend.model.product.Ingredient;
import be.fooda.frontend.model.product.Product;
import be.fooda.frontend.model.product.Tag;
import be.fooda.frontend.service.BasketService;
import be.fooda.frontend.service.ProductService;
import com.vaadin.componentfactory.Autocomplete;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Route(value = "foods", layout = MainView.class)
@PageTitle("Fooda | Foods")
public class FoodsView extends VerticalLayout {

    private final ProductService productService;
    private final BasketService basketService;

    private final VerticalLayout searchLayout = new VerticalLayout();
    private final static String SEARCH_SLOGAN = "May the food be with you!";
    private final Autocomplete searchFieldWithAutoComplete = new Autocomplete(10);
    private final Button searchButton = new Button(VaadinIcon.SEARCH.create());

    private final VerticalLayout productsLayout = new VerticalLayout();

    public FoodsView(ProductService productService, BasketService basketService) {
        this.productService = productService;
        this.basketService = basketService;
        addClassName("page");

        //        START -> SEARCH LAYOUT COMPONENTS

        final ResponseEntity categoriesResponse = productService.getAllCategories();
        final ResponseEntity tagsResponse = productService.getAllTags();
        final ResponseEntity ingredientsResponse = productService.getAllIngredients();

        List<String> autocompleteData = new ArrayList<>();

        if (categoriesResponse.getStatusCode().equals(HttpStatus.FOUND) && categoriesResponse.hasBody()) {
            Category[] categories = (Category[]) categoriesResponse.getBody();
            if (categories != null) {
                for (Category category : categories) {
                    autocompleteData.add(category.getTitle());
                }
            }
        }

        if (tagsResponse.getStatusCode().equals(HttpStatus.FOUND) && tagsResponse.hasBody()) {
            Tag[] tags = (Tag[]) tagsResponse.getBody();
            if (tags != null) {
                for (Tag tag : tags) {
                    autocompleteData.add(tag.getValue());
                }
            }
        }

        if (ingredientsResponse.getStatusCode().equals(HttpStatus.FOUND) && ingredientsResponse.hasBody()) {
            Ingredient[] ingredients = (Ingredient[]) ingredientsResponse.getBody();
            if (ingredients != null) {
                for (Ingredient ingredient : ingredients) {
                    autocompleteData.add(ingredient.getIngredientName());
                }
            }
        }

        List<String> autocompleteDataDuplicatesRemoved = autocompleteData.stream().distinct().collect(Collectors.toList());

        searchFieldWithAutoComplete.addChangeListener(event -> searchFieldWithAutoComplete.setOptions(autocompleteDataDuplicatesRemoved));
        searchFieldWithAutoComplete.addAutocompleteValueAppliedListener(event -> {
            if (!event.getValue().isEmpty()) {
                final String hashTagValue = " " + "#" + event.getValue();
                final String previousHasTagValues = searchFieldWithAutoComplete.getLabel().contentEquals(SEARCH_SLOGAN) ? "" : searchFieldWithAutoComplete.getLabel();
                searchFieldWithAutoComplete.setLabel(previousHasTagValues + hashTagValue);
            }
        });
        searchFieldWithAutoComplete.addValueClearListener(event -> {
            searchFieldWithAutoComplete.setValue("");
        });
        searchFieldWithAutoComplete.setCaseSensitive(false);
        searchFieldWithAutoComplete.setWidth("50vw");
        searchFieldWithAutoComplete.setMaxWidth("65vw");
        searchFieldWithAutoComplete.setLabel(SEARCH_SLOGAN);
        searchFieldWithAutoComplete.setPlaceholder("search ...");
        searchFieldWithAutoComplete.getElement().getStyle()
                .set("font-size", "medium")
                .set("background", "transparent");

        searchButton.setWidth("15vw");
        searchButton.setMaxWidth("25vw");
        searchButton.getStyle()
                .set("font-size", "medium")
                .set("background", "transparent");
        searchButton.addClickListener(onSearchClick -> {

            productsLayout.removeAll();

            if (!searchFieldWithAutoComplete.getValue().isEmpty()) {
                final String[] keywords = Arrays.stream(searchFieldWithAutoComplete.getLabel().split("#")).toArray(String[]::new);
                List<Product> searchResults = new ArrayList<>();
                for (String keyword : keywords) {
                    final String simplifiedKeyword = keyword.replace("#", "").replace(" ", "");
                    final ResponseEntity searchResponse = productService.searchByName(simplifiedKeyword, 1, 25);
                    if (searchResponse.getStatusCode().equals(HttpStatus.FOUND) && searchResponse.hasBody()) {
                        Product[] searchResultsByKeyword = (Product[]) searchResponse.getBody();
                        if (searchResultsByKeyword != null) {
                            searchResults.addAll(Arrays.asList(searchResultsByKeyword));
                        }
                    } else {
                        new Notification("Nothing is found with this search..", 2000, Notification.Position.BOTTOM_CENTER).open();
                    }
                }

                Product[] searchResultsWithDuplicatesRemoved = searchResults.stream().distinct().toArray(Product[]::new);

                for (Product product : searchResultsWithDuplicatesRemoved) {
                    productsLayout.add(new ProductLayout(product));
                }
            }
        });

        searchLayout.add(searchFieldWithAutoComplete, searchButton);

//        END -> SEARCH LAYOUT COMPONENTS

//        START -> PRODUCTS LAYOUT COMPONENTS

        final ResponseEntity response = productService.getAll(1, 10);
        Product[] products = (Product[]) response.getBody();

        if (response.getStatusCode().equals(HttpStatus.FOUND) && products != null && products.length > 0) {
            for (Product product : products) {
                productsLayout.add(new ProductLayout(product));
            }
        }

//        END -> PRODUCTS LAYOUT COMPONENTS

        add(searchLayout, productsLayout);

    }
}
