package be.fooda.frontend.models.store;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.URL;

public class storeImage {

    private Long id;

    private Long externalMediaId;


    private storeUser.Type type;

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

    public storeUser.Type getType() {
        return type;
    }

    public void setType(storeUser.Type type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }






}
