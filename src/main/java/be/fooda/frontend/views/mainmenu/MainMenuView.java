package be.fooda.frontend.views.mainmenu;

import be.fooda.frontend.models.product.Product;
import be.fooda.frontend.models.product.ProductCategory;
import be.fooda.frontend.service.ProductService;
import be.fooda.frontend.views.main.MainView;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.BigDecimalField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextFieldVariant;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
            for (Product product : products) {
                createProductCardLayout(product);
            }
        }
    }

    private void createProductCardLayout(Product product) {

        VerticalLayout productCardLayout = new VerticalLayout();
        productCardLayout.addClassName("product-card-layout");

        Image img = new Image(product.getImages().get(0).getUrl(), product.getProductName());
        img.addClassName("product-img");

        NumberField qty = new NumberField();
        qty.setValue(1d);
        qty.setHasControls(true);
        qty.setMin(1);
        qty.setMax(product.getLimitPerOrder());
        qty.addClassName("product-quantity");

        BigDecimalField price = new BigDecimalField("Total:");
        price.addThemeVariants(TextFieldVariant.LUMO_ALIGN_RIGHT);
        price.setPrefixComponent(new Icon(VaadinIcon.EURO));
        price.addClassName("product-price");

        Label tax = new Label();
        tax.addClassName("product-tax");

        qty.addValueChangeListener(onQuantityChange -> {
            price.setValue(product.getPrices().get(0).getAmount().multiply(BigDecimal.valueOf(qty.getValue())).setScale(2));
        });

        price.addValueChangeListener(e -> {
            BigDecimal taxValue;
            if (e.getValue() == null) {
                taxValue = BigDecimal.ZERO;
            } else {
                taxValue = e.getValue().multiply(new BigDecimal(product.getTaxes().get(0).getPercentage())).setScale(2, RoundingMode.HALF_EVEN);
            }
            tax.setText("VAT " + product.getTaxes().get(0).getPercentage() + "%: " + taxValue + product.getPrices().get(0).getCurrency());
        });

        final Label name = new Label(product.getProductName());
        name.addClassName("product-name");

        final Label description = new Label(product.getDescription());
        description.addClassNames("product-description");

        Button addToBasket = new Button("Add to Basket", onClick -> {
            new Notification(product.getProductName() + " is added to basket.. ").open();
        });
        addToBasket.addClassName("product-add-to-basket");

        // get image
        VerticalLayout imageLayout = new VerticalLayout();
        imageLayout.add(img);

        // get name, get description, get ingredients ..
        VerticalLayout nameAndDescLayout = new VerticalLayout();
        nameAndDescLayout.add(name, description);

        // change quantity, set price, get tax info, add to basket ..
        HorizontalLayout quantityAndPriceLayout = new HorizontalLayout();
        quantityAndPriceLayout.add(qty, price, tax);

        // change quantity, set price, get tax info, add to basket ..
        HorizontalLayout actionButtonsLayout = new HorizontalLayout();
        actionButtonsLayout.add(addToBasket);

        productCardLayout.add(imageLayout, nameAndDescLayout, quantityAndPriceLayout, actionButtonsLayout);
        add(productCardLayout);
    }

    private void initProductCategoriesFromResponse(ResponseEntity<ProductCategory[]> responseEntity) {
        if (!responseEntity.getStatusCode().equals(HttpStatus.SERVICE_UNAVAILABLE) && responseEntity.getBody() != null) {
            List<ProductCategory> categories = Arrays.asList(responseEntity.getBody());

            Accordion accordion = new Accordion();

            FormLayout categoriesSelectionForm = new FormLayout();
            categoriesSelectionForm.addClassName("product-categories");
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
