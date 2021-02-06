package be.fooda.frontend.model.store;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Auth implements Serializable {

    private UUID id;

    private String authKey;

    private String secret;

    private LocalDate expiryDate;

    private String siteUrl;

    private String storeUrl;

    public Auth() {
    }

    public Auth(String authKey, String secret) {
        this.authKey = authKey;
        this.secret = secret;
    }

    public Auth(String authKey, String secret, String siteUrl, String storeUrl) {
        this.authKey = authKey;
        this.secret = secret;
        this.siteUrl = siteUrl;
        this.storeUrl = storeUrl;
    }

    public Auth(String authKey, String secret, LocalDate expiryDate, String siteUrl, String storeUrl) {
        this.authKey = authKey;
        this.secret = secret;
        this.expiryDate = expiryDate;
        this.siteUrl = siteUrl;
        this.storeUrl = storeUrl;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAuthKey() {
        return authKey;
    }

    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public String getStoreUrl() {
        return storeUrl;
    }

    public void setStoreUrl(String storeUrl) {
        this.storeUrl = storeUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auth auth = (Auth) o;
        return Objects.equals(id, auth.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
