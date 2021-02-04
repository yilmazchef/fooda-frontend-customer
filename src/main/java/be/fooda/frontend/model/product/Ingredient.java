package be.fooda.frontend.model.product;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

public class Ingredient implements Serializable {

    private UUID id;

    private String ingredientName;

    private BigDecimal price= BigDecimal.valueOf(0.0);

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
}
