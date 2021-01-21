package be.fooda.frontend.views.basket;

import be.fooda.frontend.components.BasketLayout;
import be.fooda.frontend.models.basket.Basket;
import be.fooda.frontend.models.basket.BasketDetail;
import be.fooda.frontend.models.basket.BasketProduct;
import be.fooda.frontend.service.BasketService;
import be.fooda.frontend.views.main.MainView;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

@Route(value = "basket", layout = MainView.class)
@PageTitle("View Basket")
public class BasketView extends Div {

    private BasketService basketService;

    private Long externalUserId = 1L;
    private String session = "FNAUN23123VSQ";
    private Long externalStoreId = 1L;

    public BasketView(BasketService basketService) {
        setId("basket-view");
        add(new Text("Basket Items .."));

        final ResponseEntity<BasketProduct[]> apiResponse = basketService.getProductsByUserAndStore(externalUserId, session, externalStoreId);
        BasketProduct[] basketProducts = apiResponse.getBody();

        Basket basket = new Basket();
        final BasketDetail basketDetail = new BasketDetail();
        basketDetail.setProducts(Arrays.asList(Objects.requireNonNull(basketProducts)));
        basket.setBasketDetails(Collections.singletonList(basketDetail));

        add(new BasketLayout(basket));

    }

}
