package be.fooda.frontend.models.media;


import com.fasterxml.jackson.annotation.JsonProperty;

public class MediaUser {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private Long externalUserId;

    private String username;

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

}
