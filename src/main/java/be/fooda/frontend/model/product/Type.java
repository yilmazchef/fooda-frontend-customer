package be.fooda.frontend.model.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum Type implements Serializable {

    SIMPLE("A product which have no variations"),
    GROUPED("A product which has variations"),
    COMPLEX("multiple products in a product");

    private final String value;

    Type(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
