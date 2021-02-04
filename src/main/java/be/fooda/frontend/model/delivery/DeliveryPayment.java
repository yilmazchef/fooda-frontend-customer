package be.fooda.frontend.model.delivery;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DeliveryPayment {

    @JsonIgnore
    private Long id;

    private Long externalPaymentId;

    private String note;

    private Boolean isSucceed;

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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean getSucceed() {
        return isSucceed;
    }

    public void setSucceed(Boolean succeed) {
        isSucceed = succeed;
    }
}
