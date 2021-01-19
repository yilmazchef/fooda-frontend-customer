package be.fooda.frontend.views.mainmenu;

import be.fooda.frontend.models.product.Product;
import be.fooda.frontend.service.BasketService;
import be.fooda.frontend.service.ProductService;
import be.fooda.frontend.views.main.MainView;
import com.github.appreciated.card.RippleClickableCard;
import com.github.appreciated.card.action.ActionButton;
import com.github.appreciated.card.action.Actions;
import com.github.appreciated.card.content.IconItem;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Route(value = "main", layout = MainView.class)
@PageTitle("Fooda | Main Menu")
public class MainMenuView extends VerticalLayout {

    private ProductService productService;
    private BasketService basketService;

    final Long externalUserId = 1L;
    final String userSession = UI.getCurrent().getSession().getSession().getId();

    public MainMenuView(ProductService productService, BasketService basketService) {
        setId("main-menu-view");
        setPadding(false);
        setMargin(false);
        setAlignItems(Alignment.CENTER);

        ResponseEntity<Product[]> responseEntity = productService.getAll(1, 2);

        if (!responseEntity.getStatusCode().equals(HttpStatus.SERVICE_UNAVAILABLE) && responseEntity.getBody() != null) {
            final Product[] products = responseEntity.getBody();
            if (products.length > 0) {
                searchProducts(products);
            } else {
                final Notification requiredSmsCodeNotification = new Notification("No Products Found..");
                requiredSmsCodeNotification.getElement().getStyle()
                        .set("color", "#FFCC00");
                requiredSmsCodeNotification.setDuration(2000);
                requiredSmsCodeNotification.open();
            }
        }
    }

    private void searchProducts(Product[] products) {

        for (Product product : products) {
            add(new ProductCardLayout(
                    product.getImages().get(0).getUrl(),
                    product.getProductName(),
                    product.getDescription()
            ));
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

    public static class StoreCardLayout extends VerticalLayout {
        public StoreCardLayout(String imagePath, String title, String description) {
            setPadding(false);
            setMargin(false);
            
            Image img = new Image(imagePath, title);
            img.setWidth("25vw");
            img.setHeight("auto");
            RippleClickableCard card = new RippleClickableCard(
                    componentEvent -> Notification.show("A RippleClickableCard was clicked!"),
                    new IconItem(img, title, description),
                    new Actions(
                            new ActionButton("View Menu", viewStoreMenu -> {
                                UI.getCurrent().navigate("restaurant_info");
                            })
                    )
            );
            card.setWidth("100vw");
            add(card);
        }
    }


}
