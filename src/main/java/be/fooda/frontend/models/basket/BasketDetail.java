package be.fooda.frontend.models.basket;

import java.util.List;

public class BasketDetail {
    BasketOrder order;
    BasketPayment payment;
    BasketStore store;
    List<BasketProduct> products;

    public BasketOrder getOrder() {
        return order;
    }

    public void setOrder(BasketOrder order) {
        this.order = order;
    }

    public BasketPayment getPayment() {
        return payment;
    }

    public void setPayment(BasketPayment payment) {
        this.payment = payment;
    }

    public BasketStore getStore() {
        return store;
    }

    public void setStore(BasketStore store) {
        this.store = store;
    }

    public List<BasketProduct> getProducts() {
        return products;
    }

    public void setProducts(List<BasketProduct> products) {
        this.products = products;
    }
}
