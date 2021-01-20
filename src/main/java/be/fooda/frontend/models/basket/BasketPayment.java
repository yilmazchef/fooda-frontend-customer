package be.fooda.frontend.models.basket;


import be.fooda.frontend.models.PaymentMethod;
import be.fooda.frontend.models.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;

public class BasketPayment {

    @JsonIgnore
    private String id;

    private BasketUser user;

    private PaymentMethod method;

    private BigDecimal amount;

    private PaymentStatus status;

    public String getId() {
        return id;
    }

    public BasketPayment setId(String id) {
        this.id = id;
        return this;
    }

    public BasketUser getUser() {
        return user;
    }

    public BasketPayment setUser(BasketUser user) {
        this.user = user;
        return this;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public BasketPayment setMethod(PaymentMethod method) {
        this.method = method;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BasketPayment setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public BasketPayment setStatus(PaymentStatus status) {
        this.status = status;
        return this;
    }
}
