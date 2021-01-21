package be.fooda.frontend.models.basket;

import be.fooda.frontend.models.PaymentMethod;
import be.fooda.frontend.models.PaymentStatus;

import java.math.BigDecimal;

public class BasketPayment {

    private String id;

    private BasketUser user;

    private PaymentMethod method;

    private BigDecimal amount;

    private PaymentStatus status;

    public BasketPayment() {
    }

    public String getId() {
        return this.id;
    }

    public BasketUser getUser() {
        return this.user;
    }

    public PaymentMethod getMethod() {
        return this.method;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public PaymentStatus getStatus() {
        return this.status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUser(BasketUser user) {
        this.user = user;
    }

    public void setMethod(PaymentMethod method) {
        this.method = method;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof BasketPayment)) return false;
        final BasketPayment other = (BasketPayment) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        final Object this$method = this.getMethod();
        final Object other$method = other.getMethod();
        if (this$method == null ? other$method != null : !this$method.equals(other$method)) return false;
        final Object this$amount = this.getAmount();
        final Object other$amount = other.getAmount();
        if (this$amount == null ? other$amount != null : !this$amount.equals(other$amount)) return false;
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BasketPayment;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        final Object $method = this.getMethod();
        result = result * PRIME + ($method == null ? 43 : $method.hashCode());
        final Object $amount = this.getAmount();
        result = result * PRIME + ($amount == null ? 43 : $amount.hashCode());
        final Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        return result;
    }

    public String toString() {
        return "FoodaBasketPayment(id=" + this.getId() + ", user=" + this.getUser() + ", method=" + this.getMethod() + ", amount=" + this.getAmount() + ", status=" + this.getStatus() + ")";
    }
}
