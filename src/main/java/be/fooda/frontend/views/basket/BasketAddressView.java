package be.fooda.frontend.views.basket;

import be.fooda.frontend.components.BasketAddressLayout;
import be.fooda.frontend.models.basket.BasketAddress;
import be.fooda.frontend.service.BasketService;
import be.fooda.frontend.views.main.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@Route(value = "basket_address", layout = MainView.class)
@PageTitle("View Basket Address")
public class BasketAddressView extends VerticalLayout {

    private BasketService basketService;

    private Long externalUserId = 1L;
    private boolean hasAddressesInBasket = false;


    public BasketAddressView(BasketService basketService) {
        setId("basket-address-view");

        final ResponseEntity<BasketAddress[]> apiResponse = basketService.getAddressesByExternalUserId(externalUserId);
        BasketAddress[] basketAddresses = apiResponse.getBody();

        if (apiResponse.getStatusCode().equals(HttpStatus.FOUND) && apiResponse.hasBody() && basketAddresses.length > 0) {
            hasAddressesInBasket = true;

            VerticalLayout addressGroupLayout = new VerticalLayout();
            addressGroupLayout.addClassName("basket-address-group-layout");
            for (BasketAddress address : basketAddresses) {
                    addressGroupLayout.add(new BasketAddressLayout(address));
            }
            add(addressGroupLayout);
        }
        Button addNewAddressButton = new Button("+ Add New Address");

        HorizontalLayout buttonsLayout = new HorizontalLayout();
        buttonsLayout.setClassName("basket-address-buttonsLayout");
        Button backButton = new Button("< Back To Basket");
        backButton.setClassName("basket-address-back-button");
        Button nextButton = new Button("Next >");
        backButton.setClassName("basket-address-next-button");
        buttonsLayout.add(backButton, nextButton);

        add(addNewAddressButton, buttonsLayout);
    }
}
