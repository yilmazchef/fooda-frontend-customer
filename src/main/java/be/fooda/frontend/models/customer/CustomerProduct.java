package be.fooda.frontend.models.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CustomerProduct {

    @JsonIgnore
    private Long id;

    private Long externalProductId;

    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}