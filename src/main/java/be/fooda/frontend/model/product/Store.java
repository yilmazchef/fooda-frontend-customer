package be.fooda.frontend.model.product;

import java.io.Serializable;
import java.util.UUID;

public class Store implements Serializable {

    private UUID id;

    private String name;

    private UUID eStoreId;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID geteStoreId() {
        return eStoreId;
    }

    public void seteStoreId(UUID eStoreId) {
        this.eStoreId = eStoreId;
    }
}
