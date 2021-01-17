package be.fooda.frontend.models.product;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProductCategory {

    @JsonIgnore
    private Long id;

    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
