package be.fooda.frontend.models.product;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProductStore {

    @JsonIgnore
    private Long id;

    private String storeName;

    private Long externalStoreId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Long getExternalStoreId() {
        return externalStoreId;
    }

    public void setExternalStoreId(Long externalStoreId) {
        this.externalStoreId = externalStoreId;
    }
}
