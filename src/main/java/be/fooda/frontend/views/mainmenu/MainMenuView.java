package be.fooda.frontend.views.mainmenu;

import be.fooda.frontend.models.product.Product;
import be.fooda.frontend.models.product.ProductCategory;
import be.fooda.frontend.service.ProductService;
import be.fooda.frontend.views.components.ProductCard;
import be.fooda.frontend.views.main.MainView;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static be.fooda.frontend.views.main.MainView.DEFAULT_PAGE_NUMBER;

@Route(value = "main", layout = MainView.class)
@PageTitle("Fooda | Main Menu")
public class MainMenuView extends VerticalLayout {

    private ProductService productService;

    public MainMenuView(ProductService productService) {
        this.productService = productService;
        setId("main-menu-view");

        setPadding(false);
        setMargin(false);
        setAlignItems(Alignment.AUTO);

        getProductCategories();

        getProducts();
    }

    private void getProductCategories() {
        final ResponseEntity<ProductCategory[]> categories = productService.getAllCategories();
        initProductCategoriesFromResponse(categories);
    }

    private void getProducts() {
        final ResponseEntity<Product[]> responseEntity = productService.getAll(DEFAULT_PAGE_NUMBER, 2);
        initProductsFromResponse(responseEntity);
    }

    private void initProductsFromResponse(ResponseEntity<Product[]> responseEntity) {
        if (!responseEntity.getStatusCode().equals(HttpStatus.SERVICE_UNAVAILABLE) && responseEntity.getBody() != null) {
            final Product[] products = responseEntity.getBody();
            Arrays.stream(products).forEachOrdered(product -> add(new ProductCard(product)));
        }
    }

    private void initProductCategoriesFromResponse(ResponseEntity<ProductCategory[]> responseEntity) {
        if (!responseEntity.getStatusCode().equals(HttpStatus.SERVICE_UNAVAILABLE) && responseEntity.getBody() != null) {
            List<ProductCategory> categories = Arrays.asList(responseEntity.getBody());

            Accordion accordion = new Accordion();

            FormLayout categoriesSelectionForm = new FormLayout();
            categories.forEach(c -> {
                final Checkbox categoryCheckBox = new Checkbox(c.getTitle(), false);
                categoryCheckBox.addValueChangeListener(onCheck -> {
                    final Boolean checked = onCheck.getValue();

                });
                categoriesSelectionForm.add(categoryCheckBox);
            });

            accordion.setWidthFull();
            accordion.add("Categories", categoriesSelectionForm);
            accordion.close();
            add(accordion);
        }
    }
}
