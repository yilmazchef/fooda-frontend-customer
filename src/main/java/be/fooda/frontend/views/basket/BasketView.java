package be.fooda.frontend.views.basket;

import be.fooda.frontend.components.BasketProductLayout;
import be.fooda.frontend.models.basket.BasketProduct;
import be.fooda.frontend.service.BasketService;
import be.fooda.frontend.views.main.MainView;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.http.ResponseEntity;

@Route(value = "basket", layout = MainView.class)
@PageTitle("View Basket")
public class BasketView extends VerticalLayout {

    private BasketService basketService;

    private Long externalUserId = 1L;
    private String session = "1";
    private Long externalStoreId = 1L;

    public BasketView(BasketService basketService) {
        setId("basket-view");
        add(new Text("Basket Items .."));

        final ResponseEntity<BasketProduct[]> apiResponse = basketService.getProductsByUserAndStore(externalUserId, session, externalStoreId);
        BasketProduct[] basketProducts = apiResponse.getBody();

        for (BasketProduct basketProduct : basketProducts) {
            add(new BasketProductLayout(basketProduct));
        }

    }

}
