package be.fooda.frontend.models.payment;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PaymentOrder {

    @JsonIgnore
    private Long id;

    private Long externalOrderId;

    private PaymentStore store;

    private Payment payment;

    public void setStore(PaymentStore store) {
        store.setOrder(this);
        this.store = store;
    }

    public Long getId() {
        return id;
    }

    public PaymentOrder setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getExternalOrderId() {
        return externalOrderId;
    }

    public PaymentOrder setExternalOrderId(Long externalOrderId) {
        this.externalOrderId = externalOrderId;
        return this;
    }

    public PaymentStore getStore() {
        return store;
    }

    public Payment getPayment() {
        return payment;
    }

    public PaymentOrder setPayment(Payment payment) {
        this.payment = payment;
        return this;
    }
}
