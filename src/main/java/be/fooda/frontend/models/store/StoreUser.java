package be.fooda.frontend.models.store;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreUser {

    Long id;


    Long externalUserId;

    String username;

    private StoreUserType type;


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

    public StoreUserType getType() {
        return type;
    }

    public void setType(StoreUserType type) {
        this.type = type;
    }



    public enum StoreUserType {
        CREATED,
        UPDATED,
        DELETED;
    }
}
