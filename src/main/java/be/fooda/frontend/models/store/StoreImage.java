package be.fooda.frontend.models.store;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreImage {

    private Long id;

    private Long externalMediaId;

    public StoreImageType getType() {
        return type;
    }

    public void setType(StoreImageType type) {
        this.type = type;
    }

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


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
