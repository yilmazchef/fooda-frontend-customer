package be.fooda.frontend.views.basket;

import be.fooda.frontend.components.BasketProductLayout;
import be.fooda.frontend.models.basket.BasketProduct;
import be.fooda.frontend.models.basket.BasketStore;
import be.fooda.frontend.service.BasketService;
import be.fooda.frontend.views.main.MainView;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Route(value = "basket_products", layout = MainView.class)
@PageTitle("View Basket Products")
public class BasketProductView extends VerticalLayout {

    private BasketService basketService;

    private Long externalUserId = 1L;
    private String session = "1";
    private Long externalStoreId = 1L;

    public BasketProductView(BasketService basketService) {
        setId("basket-products-view");

        final ResponseEntity<BasketProduct[]> apiResponse = basketService.getProductsByUser(externalUserId, session);
        BasketProduct[] basketProducts = apiResponse.getBody();

        if (apiResponse.getStatusCode().equals(HttpStatus.FOUND) && apiResponse.hasBody() && basketProducts.length > 0) {
            Map<BasketStore, List<BasketProduct>> storeGroup = Arrays
                    .stream(basketProducts)
                    .collect(Collectors.groupingBy(BasketProduct::getStore));

            storeGroup.forEach((store, products) -> {
                VerticalLayout storeGroupLayout = new VerticalLayout();
                storeGroupLayout.addClassName("basket-products-store-group-layout");
                H2 storeName = new H2(store.getName());
                storeName.addClassName("basket-products-store-name");
                storeGroupLayout.add(storeName);
                for (BasketProduct product : products) {
                    System.out.println(product.getName());
                    storeGroupLayout.add(new BasketProductLayout(product));
                }

                add(storeGroupLayout);
            });

        }

    }

}
