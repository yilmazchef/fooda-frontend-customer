package be.fooda.frontend.views.searchfood;

import be.fooda.frontend.models.product.Product;
import be.fooda.frontend.service.BasketService;
import be.fooda.frontend.service.ProductService;
import be.fooda.frontend.views.main.MainView;
import be.fooda.frontend.views.mainmenu.MainMenuView;
import com.github.appreciated.card.RippleClickableCard;
import com.github.appreciated.card.content.IconItem;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@Route(value = "search_food", layout = MainView.class)
@PageTitle("Search Food")
public class SearchFoodView extends VerticalLayout {

    private ProductService productService;
    private BasketService basketService;

    private final HorizontalLayout searchLayout;
    private final TextField searchField;
    private final VerticalLayout productLayout;
    private final Button searchButton;


    //    final Long externalUserId = Long.valueOf(UI.getCurrent().getSession().getAttribute("externalUserId").toString());
    final Long externalUserId = 1L;
    final String userSession = UI.getCurrent().getSession().getSession().getId();
    final List<Product> productList = new ArrayList<>();

    public SearchFoodView(ProductService productService, BasketService basketService) {
        this.productService = productService;
        this.basketService = basketService;

        setId("search-food-view");

        setPadding(false);
        setMargin(false);
        setAlignItems(FlexComponent.Alignment.CENTER);

        this.searchLayout = new HorizontalLayout();
        searchLayout.setPadding(false);
        searchLayout.setMargin(false);

        this.searchField = new TextField();
        searchField.setAutofocus(true);

        this.productLayout = new VerticalLayout();
        productLayout.setMargin(false);
        productLayout.setPadding(false);

        this.searchButton = new Button("Search", onClick -> {
            productLayout.removeAll();
            initProducts();
        });
        searchLayout.setFlexGrow(0.5, searchButton);
        searchLayout.setWidthFull();

        searchLayout.add(searchField, searchButton);
        add(searchLayout, productLayout);
    }

    private void initProducts() {

        final ResponseEntity<Product[]> responseEntity = productService.getAll(1, 25);

        if (!responseEntity.getStatusCode().equals(HttpStatus.SERVICE_UNAVAILABLE) && responseEntity.getBody() != null) {
            final Product[] products = responseEntity.getBody();
            if (products.length > 0) {

                for (Product product : products) {
                    productLayout.add(new MainMenuView.ProductCardLayout(
                            product.getImages().get(0).getUrl(),
                            product.getProductName(),
                            product.getDescription()
                    ));
                }
            } else {
                final Notification requiredSmsCodeNotification = new Notification("No Products Found..");
                requiredSmsCodeNotification.getElement().getStyle().set("color", "#FFCC00");
                requiredSmsCodeNotification.setDuration(2000);
                requiredSmsCodeNotification.open();
            }
        }
    }

    public static class ProductCardLayout extends VerticalLayout {
        public ProductCardLayout(String imagePath, String title, String description) {
            setPadding(false);
            setMargin(false);

            Image img = new Image(imagePath, title);
            img.setWidth("25vw");
            img.setHeight("auto");
            RippleClickableCard card = new RippleClickableCard(
                    componentEvent -> Notification.show("A RippleClickableCard was clicked!"),
                    new IconItem(img, title, description)
            );
            card.setWidth("100vw");
            add(card);
        }
    }

}
