package be.fooda.frontend.model.product;

import java.io.Serializable;
import java.util.UUID;

public class Tag implements Serializable {

    private UUID id;

    private String value;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
