package be.fooda.frontend.model.basket;

public class BasketStore {

    private String id;

    private Long externalStoreId;

    private String name;

    public BasketStore() {
    }

    public String getId() {
        return this.id;
    }

    public Long getExternalStoreId() {
        return this.externalStoreId;
    }

    public String getName() {
        return this.name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setExternalStoreId(Long externalStoreId) {
        this.externalStoreId = externalStoreId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof BasketStore)) return false;
        final BasketStore other = (BasketStore) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$externalStoreId = this.getExternalStoreId();
        final Object other$externalStoreId = other.getExternalStoreId();
        if (this$externalStoreId == null ? other$externalStoreId != null : !this$externalStoreId.equals(other$externalStoreId))
            return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BasketStore;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $externalStoreId = this.getExternalStoreId();
        result = result * PRIME + ($externalStoreId == null ? 43 : $externalStoreId.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        return result;
    }

    public String toString() {
        return "FoodaBasketStore(id=" + this.getId() + ", externalStoreId=" + this.getExternalStoreId() + ", name=" + this.getName() + ")";
    }
}
