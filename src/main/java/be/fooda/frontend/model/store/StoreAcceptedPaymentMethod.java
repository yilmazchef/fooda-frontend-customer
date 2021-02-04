package be.fooda.frontend.model.store;

import be.fooda.frontend.model.PaymentMethod;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;


public class StoreAcceptedPaymentMethod {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private PaymentMethod paymentMethod;

    private BigDecimal minOrderAmount;


    private LocalDate expiryDate;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getMinOrderAmount() {
        return minOrderAmount;
    }

    public void setMinOrderAmount(BigDecimal minOrderAmount) {
        this.minOrderAmount = minOrderAmount;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
}
