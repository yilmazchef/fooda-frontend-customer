package be.fooda.frontend.model.basket;


import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Ingredient implements Serializable {

    private String id;

    private String eIngredientId;

    private BigDecimal cost;

    public Ingredient() {
    }

    public Ingredient(String id, String eIngredientId, BigDecimal cost) {
        this.id = id;
        this.eIngredientId = eIngredientId;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String geteIngredientId() {
        return eIngredientId;
    }

    public void seteIngredientId(String eIngredientId) {
        this.eIngredientId = eIngredientId;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("eIngredientId", eIngredientId)
                .toString();
    }
}
