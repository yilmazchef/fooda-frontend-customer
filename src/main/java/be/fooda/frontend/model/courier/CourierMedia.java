package be.fooda.frontend.model.courier;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class CourierMedia {

    @JsonIgnore
    private Long id;

    private Long externalMediaId;

    private String url;

    private MediaType type;

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

    public MediaType getType() {
        return type;
    }

    public void setType(MediaType type) {
        this.type = type;
    }

    public enum MediaType {
        PROFILE_IMAGE,
        INTRO_VIDEO;

    }
}
