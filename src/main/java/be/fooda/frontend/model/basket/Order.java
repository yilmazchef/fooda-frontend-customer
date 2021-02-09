package be.fooda.frontend.model.basket;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalTime;
import java.util.Objects;

public class Order {

    private String id;

    private User user;

    private Store store;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime requiredTime;

    private String note;

    public Order() {
    }

    public Order(String id, User user, Store store, LocalTime requiredTime, String note) {
        this.id = id;
        this.user = user;
        this.store = store;
        this.requiredTime = requiredTime;
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("requiredTime", requiredTime)
                .toString();
    }
}
