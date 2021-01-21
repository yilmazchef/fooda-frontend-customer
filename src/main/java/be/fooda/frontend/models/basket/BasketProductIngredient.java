package be.fooda.frontend.models.basket;


import java.math.BigDecimal;

public class BasketProductIngredient {

    private String id;

    private Long externalProductIngredientId;

    private BigDecimal cost;

    public BasketProductIngredient() {
    }

    public String getId() {
        return this.id;
    }

    public Long getExternalProductIngredientId() {
        return this.externalProductIngredientId;
    }

    public BigDecimal getCost() {
        return this.cost;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setExternalProductIngredientId(Long externalProductIngredientId) {
        this.externalProductIngredientId = externalProductIngredientId;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof BasketProductIngredient)) return false;
        final BasketProductIngredient other = (BasketProductIngredient) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$externalProductIngredientId = this.getExternalProductIngredientId();
        final Object other$externalProductIngredientId = other.getExternalProductIngredientId();
        if (this$externalProductIngredientId == null ? other$externalProductIngredientId != null : !this$externalProductIngredientId.equals(other$externalProductIngredientId))
            return false;
        final Object this$cost = this.getCost();
        final Object other$cost = other.getCost();
        if (this$cost == null ? other$cost != null : !this$cost.equals(other$cost)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BasketProductIngredient;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $externalProductIngredientId = this.getExternalProductIngredientId();
        result = result * PRIME + ($externalProductIngredientId == null ? 43 : $externalProductIngredientId.hashCode());
        final Object $cost = this.getCost();
        result = result * PRIME + ($cost == null ? 43 : $cost.hashCode());
        return result;
    }

    public String toString() {
        return "FoodaBasketProductIngredient(id=" + this.getId() + ", externalProductIngredientId=" + this.getExternalProductIngredientId() + ", cost=" + this.getCost() + ")";
    }
}
