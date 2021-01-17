package be.fooda.frontend.models.product;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class Product {

    @JsonIgnore
    private Long id;

    private String productName;

    private Long externalProductId;

    private ProductUser user;

    private String description;

    private Integer limitPerOrder;

    private Boolean isFeatured;

    private ProductStore store;

    private ProductType type; // SIMPLE, GROUPED, COMPLEX

    private List<ProductPrice> prices;

    private List<ProductTax> taxes;

    private List<ProductMedia> images;

    private List<ProductCategory> categories;

    private List<ProductTag> tags;

    private List<ProductIngredient> ingredients;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getExternalProductId() {
        return externalProductId;
    }

    public void setExternalProductId(Long externalProductId) {
        this.externalProductId = externalProductId;
    }

    public ProductUser getUser() {
        return user;
    }

    public void setUser(ProductUser user) {
        this.user = user;
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

    public ProductStore getStore() {
        return store;
    }

    public void setStore(ProductStore store) {
        this.store = store;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public List<ProductPrice> getPrices() {
        return prices;
    }

    public void setPrices(List<ProductPrice> prices) {
        this.prices = prices;
    }

    public List<ProductTax> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<ProductTax> taxes) {
        this.taxes = taxes;
    }

    public List<ProductMedia> getImages() {
        return images;
    }

    public void setImages(List<ProductMedia> images) {
        this.images = images;
    }

    public List<ProductCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<ProductCategory> categories) {
        this.categories = categories;
    }

    public List<ProductTag> getTags() {
        return tags;
    }

    public void setTags(List<ProductTag> tags) {
        this.tags = tags;
    }

    public List<ProductIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<ProductIngredient> ingredients) {
        this.ingredients = ingredients;
    }
}

