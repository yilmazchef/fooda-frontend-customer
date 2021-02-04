package be.fooda.frontend.model.user;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public class User {

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String login, String password, String validationCode) {
        this.login = login;
        this.password = password;
        this.validationCode = validationCode;
    }

    private UUID id;

    private String login;

    private String password;

    private Boolean isActive;

    private String validationCode;

    private LocalDateTime validationExpiry;

    private Boolean isAuthenticated;

    private LocalDateTime registry;

    private LocalDateTime lastUpdated;

    private Set<Role> roles;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getValidationCode() {
        return validationCode;
    }

    public void setValidationCode(String validationCode) {
        this.validationCode = validationCode;
    }

    public LocalDateTime getValidationExpiry() {
        return validationExpiry;
    }

    public void setValidationExpiry(LocalDateTime validationExpiry) {
        this.validationExpiry = validationExpiry;
    }

    public Boolean getAuthenticated() {
        return isAuthenticated;
    }

    public void setAuthenticated(Boolean authenticated) {
        isAuthenticated = authenticated;
    }

    public LocalDateTime getRegistry() {
        return registry;
    }

    public void setRegistry(LocalDateTime registry) {
        this.registry = registry;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
