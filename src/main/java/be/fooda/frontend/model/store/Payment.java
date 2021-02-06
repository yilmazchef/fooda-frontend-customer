package be.fooda.frontend.model.store;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Payment implements Serializable {

    private UUID id;

    private String method;

    private BigDecimal minOrderAmount;

    private LocalDate expiryDate;

    public Payment() {
    }

    public Payment(String method, BigDecimal minOrderAmount, LocalDate expiryDate) {
        this.method = method;
        this.minOrderAmount = minOrderAmount;
        this.expiryDate = expiryDate;
    }

    public Payment(UUID id, String method, BigDecimal minOrderAmount, LocalDate expiryDate) {
        this.id = id;
        this.method = method;
        this.minOrderAmount = minOrderAmount;
        this.expiryDate = expiryDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
