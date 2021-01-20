package be.fooda.frontend.models.basket;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class BasketProductIngredient {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;

    private Long externalProductIngredientId;

    private BigDecimal cost;

    public String getId() {
        return id;
    }

    public BasketProductIngredient setId(String id) {
        this.id = id;
        return this;
    }

    public Long getExternalProductIngredientId() {
        return externalProductIngredientId;
    }

    public BasketProductIngredient setExternalProductIngredientId(Long externalProductIngredientId) {
        this.externalProductIngredientId = externalProductIngredientId;
        return this;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public BasketProductIngredient setCost(BigDecimal cost) {
        this.cost = cost;
        return this;
    }
}
