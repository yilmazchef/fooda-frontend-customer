package be.fooda.frontend.models.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;

public class OrderPayment {

    @JsonIgnore
    private Long id;

    private Long externalPaymentItemId;

    private BigDecimal amount;


    public Long getId() {
        return id;
    }

    public Long getExternalPaymentItemId() {
        return externalPaymentItemId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setExternalPaymentItemId(Long externalPaymentItemId) {
        this.externalPaymentItemId = externalPaymentItemId;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}