package be.fooda.frontend.model.product;

import java.io.Serializable;
import java.util.UUID;


public class Category implements Serializable {

    private UUID id;

    private String title;

    private Byte[] icon;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Byte[] getIcon() {
        return icon;
    }

    public void setIcon(Byte[] icon) {
        this.icon = icon;
    }
}
