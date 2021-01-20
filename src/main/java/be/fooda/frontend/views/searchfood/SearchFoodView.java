package be.fooda.frontend.views.searchfood;

import be.fooda.frontend.models.product.Product;
import be.fooda.frontend.service.ProductService;
import be.fooda.frontend.views.main.MainView;
import com.github.appreciated.card.Card;
import com.github.appreciated.card.action.ActionButton;
import com.github.appreciated.card.action.Actions;
import com.github.appreciated.card.content.IconItem;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.BigDecimalField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.TextFieldVariant;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static be.fooda.frontend.views.main.MainView.DEFAULT_PAGE_NUMBER;
import static be.fooda.frontend.views.main.MainView.RESULTS_PER_PAGE;

@Route(value = "search_food", layout = MainView.class)
@PageTitle("Search Food")
public class SearchFoodView extends VerticalLayout {

    private final ProductService productService;

    private final HorizontalLayout searchLayout = new HorizontalLayout();
    private final TextField searchField = new TextField();
    private final Button searchButton = new Button();

    public SearchFoodView(ProductService productService) {
        this.productService = productService;
        setId("search-food-view");

        setPadding(false);
        setMargin(false);
        setAlignItems(Alignment.AUTO);

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
        final ResponseEntity<Product[]> responseEntity = productService.searchByName(productName, DEFAULT_PAGE_NUMBER, RESULTS_PER_PAGE);
        initProductsFromResponse(responseEntity);
    }

    private void getAllProducts() {
        final ResponseEntity<Product[]> responseEntity = productService.getAll(DEFAULT_PAGE_NUMBER, RESULTS_PER_PAGE);
        initProductsFromResponse(responseEntity);
    }

    private void initProductsFromResponse(ResponseEntity<Product[]> responseEntity) {

        if (!responseEntity.getStatusCode().equals(HttpStatus.SERVICE_UNAVAILABLE) && responseEntity.getBody() != null) {
            final Product[] products = responseEntity.getBody();

            for (Product product : products) {

                Image img = new Image(product.getImages().get(0).getUrl(), product.getProductName());
                img.setWidth("50px");
                img.setHeight("50px");

                NumberField qty = new NumberField();
                qty.setValue(1d);
                qty.setHasControls(true);
                qty.setMin(1);
                qty.setMax(product.getLimitPerOrder());

                BigDecimalField price = new BigDecimalField("Total cost");
                price.addThemeVariants(TextFieldVariant.LUMO_ALIGN_RIGHT);
                price.setPrefixComponent(new Icon(VaadinIcon.EURO));

                Label taxLabel = new Label();

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
                    taxLabel.setText("VAT " + product.getTaxes().get(0).getPercentage() + "%: " + taxValue + product.getPrices().get(0).getCurrency());
                });

                VerticalLayout productLeftLayout = new VerticalLayout();
                productLeftLayout.setPadding(false);
                productLeftLayout.add(img);

                VerticalLayout productRightLayout = new VerticalLayout();
                productRightLayout.setPadding(false);
                productRightLayout.add(new H3(product.getProductName()), new Paragraph(product.getDescription()), qty, price);

                Card card = new Card(
                        new IconItem(productLeftLayout, productRightLayout),
                        new Actions(
                                new ActionButton("Add to Basket")
                        )
                );
                card.setWidth("100%");
                add(card);
            }

        }
    }


}
