package be.fooda.frontend.model.basket;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;
import java.util.Objects;

public class Payment {

    private String id;

    private User user;

    private PaymentMethod method;

    private BigDecimal amount;

    private PaymentStatus status;

    public Payment() {
    }

    public Payment(String id, User user, PaymentMethod method, BigDecimal amount, PaymentStatus status) {
        this.id = id;
        this.user = user;
        this.method = method;
        this.amount = amount;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("amount", amount)
                .append("status", status)
                .toString();
    }
}
