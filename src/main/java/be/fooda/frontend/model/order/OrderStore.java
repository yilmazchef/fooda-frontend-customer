package be.fooda.frontend.model.order;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class OrderStore {

    @JsonIgnore
    private Long id;

    private Long externalStoreId;

    private String storeName;

}