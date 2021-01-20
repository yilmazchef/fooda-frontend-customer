package be.fooda.frontend.models.payment;

import be.fooda.frontend.models.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class Payment {

    @JsonIgnore
    private Long id;

    private Boolean isActive = Boolean.TRUE;

    private PaymentStatus status;

    private List<PaymentItem> items;

    private PaymentUser user;

    private PaymentOrder order;

    private LocalDateTime created;

    private LocalDateTime updated;

    private String note;

    public void setItems(List<PaymentItem> items) {
        this.items = items
                .stream()
                .map(this::setOneItem)
                .collect(Collectors.toList());
    }

    private PaymentItem setOneItem(PaymentItem item) {
        item.setPayment(this);
        return item;
    }

    public void setUser(PaymentUser user) {
        user.setPayment(this);
        this.user = user;
    }

    public void setOrder(PaymentOrder order) {
        order.setPayment(this);
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public Payment setId(Long id) {
        this.id = id;
        return this;
    }

    public Boolean getActive() {
        return isActive;
    }

    public Payment setActive(Boolean active) {
        isActive = active;
        return this;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public Payment setStatus(PaymentStatus status) {
        this.status = status;
        return this;
    }

    public List<PaymentItem> getItems() {
        return items;
    }

    public PaymentUser getUser() {
        return user;
    }

    public PaymentOrder getOrder() {
        return order;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public Payment setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public Payment setUpdated(LocalDateTime updated) {
        this.updated = updated;
        return this;
    }

    public String getNote() {
        return note;
    }

    public Payment setNote(String note) {
        this.note = note;
        return this;
    }
}
