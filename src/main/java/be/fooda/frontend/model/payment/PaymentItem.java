package be.fooda.frontend.model.payment;

import be.fooda.frontend.model.PaymentMethod;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class PaymentItem {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private BigDecimal amount;

    private PaymentMethod paymentMethod;

    private Payment payment;

    public Long getId() {
        return id;
    }

    public PaymentItem setId(Long id) {
        this.id = id;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public PaymentItem setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public PaymentItem setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    public Payment getPayment() {
        return payment;
    }

    public PaymentItem setPayment(Payment payment) {
        this.payment = payment;
        return this;
    }
}
