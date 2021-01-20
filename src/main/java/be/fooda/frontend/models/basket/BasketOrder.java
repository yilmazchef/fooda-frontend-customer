package be.fooda.frontend.models.basket;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalTime;


public class BasketOrder {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;

    private BasketUser user;

    private BasketStore store;

    private LocalTime requiredTime;

    private String note;

    public String getId() {
        return id;
    }

    public BasketOrder setId(String id) {
        this.id = id;
        return this;
    }

    public BasketUser getUser() {
        return user;
    }

    public BasketOrder setUser(BasketUser user) {
        this.user = user;
        return this;
    }

    public BasketStore getStore() {
        return store;
    }

    public BasketOrder setStore(BasketStore store) {
        this.store = store;
        return this;
    }

    public LocalTime getRequiredTime() {
        return requiredTime;
    }

    public BasketOrder setRequiredTime(LocalTime requiredTime) {
        this.requiredTime = requiredTime;
        return this;
    }

    public String getNote() {
        return note;
    }

    public BasketOrder setNote(String note) {
        this.note = note;
        return this;
    }
}
