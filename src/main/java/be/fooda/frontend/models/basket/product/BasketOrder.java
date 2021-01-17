package be.fooda.frontend.models.basket.product;


import java.time.LocalTime;

public class BasketOrder {

    private BasketUser user;

    private BasketStore store;

    private LocalTime requiredTime;

    private String note;

    public BasketUser getUser() {
        return user;
    }

    public void setUser(BasketUser user) {
        this.user = user;
    }

    public BasketStore getStore() {
        return store;
    }

    public void setStore(BasketStore store) {
        this.store = store;
    }

    public LocalTime getRequiredTime() {
        return requiredTime;
    }

    public void setRequiredTime(LocalTime requiredTime) {
        this.requiredTime = requiredTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
