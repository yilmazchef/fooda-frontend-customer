package be.fooda.frontend.models.store;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class storeUser {

    Long id;


    Long externalUserId;

    String username;

    private Type type;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getExternalUserId() {
        return externalUserId;
    }

    public void setExternalUserId(Long externalUserId) {
        this.externalUserId = externalUserId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }





    public enum Type {
        CREATED,
        UPDATED,
        DELETED;
    }
}
