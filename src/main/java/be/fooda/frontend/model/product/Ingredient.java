package be.fooda.frontend.model.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Locale;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ingredient implements Serializable {

    private UUID id;

    private String ingredientName;

    private BigDecimal price = BigDecimal.valueOf(0.0);

    public Ingredient() {
    }

    public Ingredient(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public Ingredient(String ingredientName, BigDecimal price) {
        this.ingredientName = ingredientName;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return ingredientName.substring(0, 1).toUpperCase(Locale.ROOT) + ingredientName.substring(1).toLowerCase(Locale.ROOT);
    }
}
