package be.fooda.frontend.models.basket.product;


import be.fooda.frontend.models.PaymentMethod;

import java.math.BigDecimal;

public class BasketPayment {

    private Long externalPaymentId;

    private BasketUser user;

    private PaymentMethod method;

    private BigDecimal amount;

    public Long getExternalPaymentId() {
        return externalPaymentId;
    }

    public void setExternalPaymentId(Long externalPaymentId) {
        this.externalPaymentId = externalPaymentId;
    }

    public BasketUser getUser() {
        return user;
    }

    public void setUser(BasketUser user) {
        this.user = user;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public void setMethod(PaymentMethod method) {
        this.method = method;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
