package be.fooda.frontend.models.basket;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.Set;

public class BasketProduct {

    @JsonIgnore
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

    public String getId() {
        return id;
    }

    public BasketProduct setId(String id) {
        this.id = id;
        return this;
    }

    public Long getExternalProductId() {
        return externalProductId;
    }

    public BasketProduct setExternalProductId(Long externalProductId) {
        this.externalProductId = externalProductId;
        return this;
    }

    public BasketUser getUser() {
        return user;
    }

    public BasketProduct setUser(BasketUser user) {
        this.user = user;
        return this;
    }

    public BasketStore getStore() {
        return store;
    }

    public BasketProduct setStore(BasketStore store) {
        this.store = store;
        return this;
    }

    public String getName() {
        return name;
    }

    public BasketProduct setName(String name) {
        this.name = name;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public BasketProduct setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BasketProduct setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BasketProduct setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BasketProduct setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public Set<BasketProductIngredient> getIngredients() {
        return ingredients;
    }

    public BasketProduct setIngredients(Set<BasketProductIngredient> ingredients) {
        this.ingredients = ingredients;
        return this;
    }
}
