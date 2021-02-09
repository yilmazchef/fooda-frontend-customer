package be.fooda.frontend.model.basket;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Product {

    private String id;

    private String eProductId;

    private User user;

    private Store store;

    private String name;

    private String imageUrl;

    private BigDecimal price;

    private String description;

    private Integer quantity;

    private Set<Ingredient> ingredients = new HashSet<>();

    public Product() {
    }

    public Product(String id, String eProductId, User user, Store store, String name, String imageUrl, BigDecimal price, String description, Integer quantity, Set<Ingredient> ingredients) {
        this.id = id;
        this.eProductId = eProductId;
        this.user = user;
        this.store = store;
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.ingredients = ingredients;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String geteProductId() {
        return eProductId;
    }

    public void seteProductId(String eProductId) {
        this.eProductId = eProductId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    public void removeIngredient(Ingredient ingredient) {
        this.ingredients.remove(ingredient);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .toString();
    }
}
