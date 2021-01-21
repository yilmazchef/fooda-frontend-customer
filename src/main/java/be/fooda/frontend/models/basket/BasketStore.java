package be.fooda.frontend.models.basket;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BasketStore {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;

    private Long externalStoreId;

    private String name;

    public String getId() {
        return id;
    }

    public BasketStore setId(String id) {
        this.id = id;
        return this;
    }

    public Long getExternalStoreId() {
        return externalStoreId;
    }

    public BasketStore setExternalStoreId(Long externalStoreId) {
        this.externalStoreId = externalStoreId;
        return this;
    }

    public String getName() {
        return name;
    }

    public BasketStore setName(String name) {
        this.name = name;
        return this;
    }
}
