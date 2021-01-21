package be.fooda.frontend.views.basket;

import be.fooda.frontend.service.BasketService;
import be.fooda.frontend.views.main.MainView;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "basket_payments", layout = MainView.class)
@PageTitle("View Basket Payments")
public class BasketPaymentView extends VerticalLayout {

    private BasketService basketService;

    private Long externalUserId = 1L;
    private String session = "1";
    private Long externalStoreId = 1L;

    public BasketPaymentView(BasketService basketService) {
        setId("basket-payments-view");


    }

}
