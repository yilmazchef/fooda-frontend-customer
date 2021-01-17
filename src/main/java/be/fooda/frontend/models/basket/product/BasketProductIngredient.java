package be.fooda.frontend.models.basket.product;

import java.math.BigDecimal;

public class BasketProductIngredient {

    private Long externalProductIngredientId;

    private BigDecimal cost;

    public Long getExternalProductIngredientId() {
        return externalProductIngredientId;
    }

    public void setExternalProductIngredientId(Long externalProductIngredientId) {
        this.externalProductIngredientId = externalProductIngredientId;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
