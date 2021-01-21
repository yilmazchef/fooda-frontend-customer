package be.fooda.frontend.models.basket;

public class BasketUser {

    private String id;

    private Long externalUserId;

    private String username;

    private String session;

    public BasketUser() {
    }

    public String getId() {
        return this.id;
    }

    public Long getExternalUserId() {
        return this.externalUserId;
    }

    public String getUsername() {
        return this.username;
    }

    public String getSession() {
        return this.session;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setExternalUserId(Long externalUserId) {
        this.externalUserId = externalUserId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof BasketUser)) return false;
        final BasketUser other = (BasketUser) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$externalUserId = this.getExternalUserId();
        final Object other$externalUserId = other.getExternalUserId();
        if (this$externalUserId == null ? other$externalUserId != null : !this$externalUserId.equals(other$externalUserId))
            return false;
        final Object this$username = this.getUsername();
        final Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) return false;
        final Object this$session = this.getSession();
        final Object other$session = other.getSession();
        if (this$session == null ? other$session != null : !this$session.equals(other$session)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BasketUser;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $externalUserId = this.getExternalUserId();
        result = result * PRIME + ($externalUserId == null ? 43 : $externalUserId.hashCode());
        final Object $username = this.getUsername();
        result = result * PRIME + ($username == null ? 43 : $username.hashCode());
        final Object $session = this.getSession();
        result = result * PRIME + ($session == null ? 43 : $session.hashCode());
        return result;
    }

    public String toString() {
        return "FoodaBasketUser(id=" + this.getId() + ", externalUserId=" + this.getExternalUserId() + ", username=" + this.getUsername() + ", session=" + this.getSession() + ")";
    }
}
