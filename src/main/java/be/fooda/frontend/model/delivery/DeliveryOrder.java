package be.fooda.frontend.model.delivery;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;

public class DeliveryOrder {

    @JsonIgnore
    private Long id;

    private Long externalOrderId;

    private String note;

    private BigDecimal total;

    private Boolean isPaid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getExternalOrderId() {
        return externalOrderId;
    }

    public void setExternalOrderId(Long externalOrderId) {
        this.externalOrderId = externalOrderId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }
}
