package be.fooda.frontend.model.store;

import java.io.Serializable;
import java.util.UUID;

public class Image implements Serializable {

    private UUID id;

    private UUID eMediaId;

    private String type;

    private String url;

    public Image() {
    }

    public Image(UUID eMediaId) {
        this.eMediaId = eMediaId;
    }

    public Image(UUID eMediaId, String url) {
        this.eMediaId = eMediaId;
        this.url = url;
    }

    public Image(UUID eMediaId, String type, String url) {
        this.eMediaId = eMediaId;
        this.type = type;
        this.url = url;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID geteMediaId() {
        return eMediaId;
    }

    public void seteMediaId(UUID eMediaId) {
        this.eMediaId = eMediaId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
