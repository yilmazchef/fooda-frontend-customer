package be.fooda.frontend.models.product;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProductTag {

    @JsonIgnore
    private Long id;

    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
