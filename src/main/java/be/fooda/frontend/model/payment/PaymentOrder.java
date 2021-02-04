package be.fooda.frontend.model.payment;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentOrder {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
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
