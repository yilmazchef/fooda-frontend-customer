package be.fooda.frontend.model.customer;

import be.fooda.frontend.model.PaymentMethod;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class CustomerPayment {

    @JsonIgnore
    private Long id;

    private Long externalPaymentId;

    private PaymentMethod method;

    private Boolean isDefault;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getExternalPaymentId() {
        return externalPaymentId;
    }

    public void setExternalPaymentId(Long externalPaymentId) {
        this.externalPaymentId = externalPaymentId;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public void setMethod(PaymentMethod method) {
        this.method = method;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }
}