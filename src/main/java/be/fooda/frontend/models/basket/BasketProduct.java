package be.fooda.frontend.models.basket;

import java.math.BigDecimal;
import java.util.Set;

public class BasketProduct {

    private String id;

    private Long externalProductId;

    private BasketUser user;

    private BasketStore store;

    private String name;

    private String imageUrl;

    private BigDecimal price;

    private String description;

    private Integer quantity;

    private Set<BasketProductIngredient> ingredients;

    public BasketProduct() {
    }

    public String getId() {
        return this.id;
    }

    public Long getExternalProductId() {
        return this.externalProductId;
    }

    public BasketUser getUser() {
        return this.user;
    }

    public BasketStore getStore() {
        return this.store;
    }

    public String getName() {
        return this.name;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public String getDescription() {
        return this.description;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public Set<BasketProductIngredient> getIngredients() {
        return this.ingredients;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setExternalProductId(Long externalProductId) {
        this.externalProductId = externalProductId;
    }

    public void setUser(BasketUser user) {
        this.user = user;
    }

    public void setStore(BasketStore store) {
        this.store = store;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setIngredients(Set<BasketProductIngredient> ingredients) {
        this.ingredients = ingredients;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof BasketProduct)) return false;
        final BasketProduct other = (BasketProduct) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$externalProductId = this.getExternalProductId();
        final Object other$externalProductId = other.getExternalProductId();
        if (this$externalProductId == null ? other$externalProductId != null : !this$externalProductId.equals(other$externalProductId))
            return false;
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        final Object this$store = this.getStore();
        final Object other$store = other.getStore();
        if (this$store == null ? other$store != null : !this$store.equals(other$store)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$imageUrl = this.getImageUrl();
        final Object other$imageUrl = other.getImageUrl();
        if (this$imageUrl == null ? other$imageUrl != null : !this$imageUrl.equals(other$imageUrl)) return false;
        final Object this$price = this.getPrice();
        final Object other$price = other.getPrice();
        if (this$price == null ? other$price != null : !this$price.equals(other$price)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        final Object this$quantity = this.getQuantity();
        final Object other$quantity = other.getQuantity();
        if (this$quantity == null ? other$quantity != null : !this$quantity.equals(other$quantity)) return false;
        final Object this$ingredients = this.getIngredients();
        final Object other$ingredients = other.getIngredients();
        if (this$ingredients == null ? other$ingredients != null : !this$ingredients.equals(other$ingredients))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BasketProduct;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $externalProductId = this.getExternalProductId();
        result = result * PRIME + ($externalProductId == null ? 43 : $externalProductId.hashCode());
        final Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        final Object $store = this.getStore();
        result = result * PRIME + ($store == null ? 43 : $store.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $imageUrl = this.getImageUrl();
        result = result * PRIME + ($imageUrl == null ? 43 : $imageUrl.hashCode());
        final Object $price = this.getPrice();
        result = result * PRIME + ($price == null ? 43 : $price.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $quantity = this.getQuantity();
        result = result * PRIME + ($quantity == null ? 43 : $quantity.hashCode());
        final Object $ingredients = this.getIngredients();
        result = result * PRIME + ($ingredients == null ? 43 : $ingredients.hashCode());
        return result;
    }

    public String toString() {
        return "FoodaBasketProduct(id=" + this.getId() + ", externalProductId=" + this.getExternalProductId() + ", user=" + this.getUser() + ", store=" + this.getStore() + ", name=" + this.getName() + ", imageUrl=" + this.getImageUrl() + ", price=" + this.getPrice() + ", description=" + this.getDescription() + ", quantity=" + this.getQuantity() + ", ingredients=" + this.getIngredients() + ")";
    }
}
