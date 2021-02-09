package be.fooda.frontend.model.basket;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Objects;

public class User {

    private String id;

    private String eUserId;

    private String username;

    private String session;

    public User() {
    }

    public User(String id, String eUserId, String username, String session) {
        this.id = id;
        this.eUserId = eUserId;
        this.username = username;
        this.session = session;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String geteUserId() {
        return eUserId;
    }

    public void seteUserId(String eUserId) {
        this.eUserId = eUserId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("username", username)
                .toString();
    }
}
