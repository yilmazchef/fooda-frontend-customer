package be.fooda.frontend.model.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Image implements Serializable {

    private UUID id;

    private UUID eImageId;

    private String url;

    private Boolean isDefault;

    public Image() {
    }

    public Image(UUID eImageId, String url) {
        this.eImageId = eImageId;
        this.url = url;
    }

    public Image(UUID eImageId, String url, Boolean isDefault) {
        this.eImageId = eImageId;
        this.url = url;
        this.isDefault = isDefault;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID geteImageId() {
        return eImageId;
    }

    public void seteImageId(UUID eImageId) {
        this.eImageId = eImageId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }
}
