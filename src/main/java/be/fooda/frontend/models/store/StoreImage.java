package be.fooda.frontend.models.store;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreImage {

    private Long id;

    private Long externalMediaId;


    private StoreUser.Type type;

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

    public StoreUser.Type getType() {
        return type;
    }

    public void setType(StoreUser.Type type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }






}
