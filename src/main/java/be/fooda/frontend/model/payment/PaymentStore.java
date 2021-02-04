package be.fooda.frontend.model.payment;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentStore {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private Long externalStoreId;

    private String name;

    private PaymentOrder order;

    public Long getId() {
        return id;
    }

    public PaymentStore setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getExternalStoreId() {
        return externalStoreId;
    }

    public PaymentStore setExternalStoreId(Long externalStoreId) {
        this.externalStoreId = externalStoreId;
        return this;
    }

    public String getName() {
        return name;
    }

    public PaymentStore setName(String name) {
        this.name = name;
        return this;
    }

    public PaymentOrder getOrder() {
        return order;
    }

    public PaymentStore setOrder(PaymentOrder order) {
        this.order = order;
        return this;
    }
}
