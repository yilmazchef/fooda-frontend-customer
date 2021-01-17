package be.fooda.frontend.models.product;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProductIngredient {

    @JsonIgnore
    private Long id;

    private String ingredientName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
}
