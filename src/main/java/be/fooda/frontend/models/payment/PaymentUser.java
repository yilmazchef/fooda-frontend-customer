package be.fooda.frontend.models.payment;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class PaymentUser {

    @JsonIgnore
    private Long id;

    private Long externalUserId;

    private String login;

    private Payment payment;

    public Long getId() {
        return id;
    }

    public PaymentUser setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getExternalUserId() {
        return externalUserId;
    }

    public PaymentUser setExternalUserId(Long externalUserId) {
        this.externalUserId = externalUserId;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public PaymentUser setLogin(String login) {
        this.login = login;
        return this;
    }

    public Payment getPayment() {
        return payment;
    }

    public PaymentUser setPayment(Payment payment) {
        this.payment = payment;
        return this;
    }
}
