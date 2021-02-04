package be.fooda.frontend.model.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CustomerOrder {

    @JsonIgnore
    private Long id;

    private Long externalOrderId;

    private String note;

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
}