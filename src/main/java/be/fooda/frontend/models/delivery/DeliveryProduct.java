package be.fooda.frontend.models.delivery;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DeliveryProduct {

    @JsonIgnore
    private Long id;

    private Long externalProductId;

    private String productName;

    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getExternalProductId() {
        return externalProductId;
    }

    public void setExternalProductId(Long externalProductId) {
        this.externalProductId = externalProductId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
