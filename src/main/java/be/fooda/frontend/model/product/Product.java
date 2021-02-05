package be.fooda.frontend.model.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product implements Serializable {

    private UUID id;

    private Boolean isActive;

    private String name;

    private String eTrackingId;

    private String createdBy;

    private String lastModifiedBy;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String description;

    private Integer limitPerOrder;

    private Boolean isFeatured;

    private Store store;

    private Type type;

    private List<Price> prices = new ArrayList<>();

    private List<Tax> taxes = new ArrayList<>();

    private Image defaultImage;

    private List<Category> categories = new ArrayList<>();

    private List<Tag> tags = new ArrayList<>();

    private List<Ingredient> ingredients = new ArrayList<>();

    public Product() {
    }

    public Product(String name, String description, Store store, Type type, List<Price> prices, List<Tax> taxes, Image defaultImage, List<Category> categories) {
        this.name = name;
        this.description = description;
        this.store = store;
        this.type = type;
        this.prices = prices;
        this.taxes = taxes;
        this.defaultImage = defaultImage;
        this.categories = categories;
    }

    public Product(String name, String description, Store store, Type type, List<Price> prices, List<Tax> taxes, Image defaultImage, List<Category> categories, List<Tag> tags) {
        this.name = name;
        this.description = description;
        this.store = store;
        this.type = type;
        this.prices = prices;
        this.taxes = taxes;
        this.defaultImage = defaultImage;
        this.categories = categories;
        this.tags = tags;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String geteTrackingId() {
        return eTrackingId;
    }

    public void seteTrackingId(String eTrackingId) {
        this.eTrackingId = eTrackingId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLimitPerOrder() {
        return limitPerOrder;
    }

    public void setLimitPerOrder(Integer limitPerOrder) {
        this.limitPerOrder = limitPerOrder;
    }

    public Boolean getFeatured() {
        return isFeatured;
    }

    public void setFeatured(Boolean featured) {
        isFeatured = featured;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    public List<Tax> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<Tax> taxes) {
        this.taxes = taxes;
    }

    public Image getDefaultImage() {
        return defaultImage;
    }

    public void setDefaultImage(Image defaultImage) {
        this.defaultImage = defaultImage;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

