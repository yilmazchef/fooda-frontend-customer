package be.fooda.frontend.model.store;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StoreImage {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private Long externalMediaId;

    private StoreImageType type;

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

    public StoreImageType getType() {
        return type;
    }

    public void setType(StoreImageType type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
