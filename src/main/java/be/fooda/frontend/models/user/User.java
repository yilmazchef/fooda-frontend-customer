package be.fooda.frontend.models.user;

import be.fooda.frontend.models.UserRole;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Set;

public class User {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private String login;

    private String password;

    private Boolean isActive = Boolean.TRUE;

    private Boolean isAuthenticated = Boolean.FALSE;

    private LocalDateTime registry;

    private LocalDateTime lastUpdated;

    private Set<UserRole> roles;

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public User setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public Boolean getActive() {
        return isActive;
    }

    public User setActive(Boolean active) {
        isActive = active;
        return this;
    }

    public Boolean getAuthenticated() {
        return isAuthenticated;
    }

    public User setAuthenticated(Boolean authenticated) {
        isAuthenticated = authenticated;
        return this;
    }

    public LocalDateTime getRegistry() {
        return registry;
    }

    public User setRegistry(LocalDateTime registry) {
        this.registry = registry;
        return this;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public User setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
        return this;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public User setRoles(Set<UserRole> roles) {
        this.roles = roles;
        return this;
    }
}
