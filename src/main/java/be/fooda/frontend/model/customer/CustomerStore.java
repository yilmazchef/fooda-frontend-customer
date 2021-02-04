package be.fooda.frontend.model.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CustomerStore {

    @JsonIgnore
    private Long id;

    private Long externalStoreId;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getExternalStoreId() {
        return externalStoreId;
    }

    public void setExternalStoreId(Long externalStoreId) {
        this.externalStoreId = externalStoreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}