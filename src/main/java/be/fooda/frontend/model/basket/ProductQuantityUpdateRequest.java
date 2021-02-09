package be.fooda.frontend.model.basket;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.Objects;

public class ProductQuantityUpdateRequest implements Serializable {

    private String eProductId;
    private String eUserId;
    private String session;
    @Positive
    private Integer newQuantity;

    public ProductQuantityUpdateRequest() {
    }

    public ProductQuantityUpdateRequest(String eProductId, String eUserId, String session, @Positive Integer newQuantity) {
        this.eProductId = eProductId;
        this.eUserId = eUserId;
        this.session = session;
        this.newQuantity = newQuantity;
    }

    public String geteProductId() {
        return eProductId;
    }

    public void seteProductId(String eProductId) {
        this.eProductId = eProductId;
    }

    public String geteUserId() {
        return eUserId;
    }

    public void seteUserId(String eUserId) {
        this.eUserId = eUserId;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public Integer getNewQuantity() {
        return newQuantity;
    }

    public void setNewQuantity(Integer newQuantity) {
        this.newQuantity = newQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductQuantityUpdateRequest that = (ProductQuantityUpdateRequest) o;
        return Objects.equals(eProductId, that.eProductId) && Objects.equals(eUserId, that.eUserId) && Objects.equals(session, that.session);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eProductId, eUserId, session);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("eProductId", eProductId)
                .append("newQuantity", newQuantity)
                .toString();
    }
}
