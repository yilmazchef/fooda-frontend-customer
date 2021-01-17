package be.fooda.frontend.models.product;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class ProductMedia {

    @JsonIgnore
    private Long id;

    private Long externalMediaId;

    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getExternalMediaId() {
        return externalMediaId;
    }

    public void setExternalMediaId(Long externalMediaId) {
        this.externalMediaId = externalMediaId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
