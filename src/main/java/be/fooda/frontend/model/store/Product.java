package be.fooda.frontend.model.store;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class Product implements Serializable {

    private UUID id;

    private UUID eProductId;

    private String name;

    private Integer menuOrder;

    private Set<String> categories = new HashSet<>();

    private String dietary;

    private String cuisine;

    private String imageUrl;

    private BigDecimal price;

    public Product() {
    }

    public Product(UUID eProductId) {
        this.eProductId = eProductId;
    }

    public Product(UUID eProductId, String name) {
        this.eProductId = eProductId;
        this.name = name;
    }

    public Product(UUID eProductId, String name, String imageUrl) {
        this.eProductId = eProductId;
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public Product(UUID eProductId, String name, String imageUrl, BigDecimal price) {
        this.eProductId = eProductId;
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
    }

    public Product(UUID eProductId, String name, Integer menuOrder, String imageUrl, BigDecimal price) {
        this.eProductId = eProductId;
        this.name = name;
        this.menuOrder = menuOrder;
        this.imageUrl = imageUrl;
        this.price = price;
    }

    public Product(UUID id, UUID eProductId, String name, Integer menuOrder, Set<String> categories, String dietary, String cuisine, String imageUrl, BigDecimal price) {
        this.id = id;
        this.eProductId = eProductId;
        this.name = name;
        this.menuOrder = menuOrder;
        this.categories = categories;
        this.dietary = dietary;
        this.cuisine = cuisine;
        this.imageUrl = imageUrl;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID geteProductId() {
        return eProductId;
    }

    public void seteProductId(UUID eProductId) {
        this.eProductId = eProductId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(Integer menuOrder) {
        this.menuOrder = menuOrder;
    }

    public Set<String> getCategories() {
        return categories;
    }

    public void setCategories(Set<String> categories) {
        this.categories = categories;
    }

    public String getDietary() {
        return dietary;
    }

    public void setDietary(String dietary) {
        this.dietary = dietary;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
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

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(eProductId, product.eProductId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eProductId);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
