package be.fooda.frontend.models.basket;

import java.util.List;

public class Basket {
    BasketAddress address;
    BasketContact contact;
    List<BasketDetail> basketDetails;

    public BasketAddress getAddress() {
        return address;
    }

    public void setAddress(BasketAddress address) {
        this.address = address;
    }

    public BasketContact getContact() {
        return contact;
    }

    public void setContact(BasketContact contact) {
        this.contact = contact;
    }

    public List<BasketDetail> getBasketDetails() {
        return basketDetails;
    }

    public void setBasketDetails(List<BasketDetail> basketDetails) {
        this.basketDetails = basketDetails;
    }
}
