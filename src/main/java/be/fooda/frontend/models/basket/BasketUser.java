package be.fooda.frontend.models.basket;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BasketUser {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;

    private Long externalUserId;

    private String username;

    private String session;

    public String getId() {
        return id;
    }

    public BasketUser setId(String id) {
        this.id = id;
        return this;
    }

    public Long getExternalUserId() {
        return externalUserId;
    }

    public BasketUser setExternalUserId(Long externalUserId) {
        this.externalUserId = externalUserId;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public BasketUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getSession() {
        return session;
    }

    public BasketUser setSession(String session) {
        this.session = session;
        return this;
    }
}
