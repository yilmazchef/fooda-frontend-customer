package be.fooda.frontend.views.searchfood;

import be.fooda.frontend.models.product.Product;
import be.fooda.frontend.service.BasketService;
import be.fooda.frontend.service.ProductService;
import be.fooda.frontend.views.main.MainView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static com.vaadin.flow.component.notification.Notification.Position.BOTTOM_CENTER;

@Route(value = "search_food", layout = MainView.class)
@PageTitle("Search Food")
public class SearchFoodView extends Div {

    private ProductService productService;
    private BasketService basketService;

    //    final Long externalUserId = Long.valueOf(UI.getCurrent().getSession().getAttribute("externalUserId").toString());
    final Long externalUserId = 1L;
    final String userSession = UI.getCurrent().getSession().getSession().getId();

    public SearchFoodView(ProductService productService, BasketService basketService) {
        this.productService = productService;
        this.basketService = basketService;

        setId("search-food-view");

        HorizontalLayout searchLayout = new HorizontalLayout();

        TextField searchField = new TextField();
        searchField.setAutofocus(true);
        searchLayout.setFlexGrow(2, searchField);
        Button searchButton = new Button("Search");
        searchButton.addClickListener(click -> searchProducts(1, 10));
        searchLayout.setFlexGrow(0.5, searchButton);
        searchLayout.setWidthFull();

        searchLayout.add(searchField, searchButton);
        add(searchLayout);

    }

    private void searchProducts(int page, int size) {
        ResponseEntity<Product[]> responseEntity = productService.getAll(page, size);

        if (!responseEntity.getStatusCode().equals(HttpStatus.FOUND)) {
            new Notification("No Products found", 3000, BOTTOM_CENTER).open();
        } else {

            Product[] products = responseEntity.getBody();

            for (Product product : Objects.requireNonNull(products)) {

                VerticalLayout productLayout = new VerticalLayout();
                productLayout.setWidthFull();

                VerticalLayout productImageLayout = new VerticalLayout();
                Image image = new Image(product.getImages().get(0).getUrl(), product.getProductName());
                image.addClassName("product_image");
                productImageLayout.add(image);
                productImageLayout.setWidthFull();

                HorizontalLayout productInfoLayout = new HorizontalLayout();
                final Label productInfoLabel = new Label(product.getProductName());
                productInfoLayout.setWidthFull();

                NumberField quantityTextField = new NumberField();
                quantityTextField.setWidth("30px");
                final Icon updateQuantityIcon = VaadinIcon.CHEVRON_CIRCLE_DOWN_O.create();
                updateQuantityIcon.setSize("40px");
                updateQuantityIcon.setColor("#F2F2F2");
                Button addToBasketButton = new Button(updateQuantityIcon);
                addToBasketButton.addClickListener(click -> {
                    basketService.updateProductQuantity(
                            product.getExternalProductId(),
                            externalUserId,
                            userSession,
                            quantityTextField.getValue().intValue());
                });
                productInfoLayout.add(productInfoLabel, quantityTextField, addToBasketButton);


                productLayout.setFlexGrow(1, productImageLayout);
                productLayout.setFlexGrow(2, productInfoLayout);
                productLayout.add(productImageLayout, productInfoLayout);
                add(productLayout);
            }
        }
    }

}
