package be.fooda.frontend.model.store;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.Objects;
import java.util.UUID;

public class Delivery implements Serializable {

    private UUID id;

    private String postcode;

    private Duration deliveryDuration;

    private BigDecimal minOrderPrice;

    private BigDecimal maxOrderPrice;

    private BigDecimal deliveryCost;

    public Delivery() {
    }

    public Delivery(String postcode) {
        this.postcode = postcode;
    }

    public Delivery(String postcode, BigDecimal deliveryCost) {
        this.postcode = postcode;
        this.deliveryCost = deliveryCost;
    }

    public Delivery(String postcode, BigDecimal minOrderPrice, BigDecimal deliveryCost) {
        this.postcode = postcode;
        this.minOrderPrice = minOrderPrice;
        this.deliveryCost = deliveryCost;
    }

    public Delivery(String postcode, Duration deliveryDuration, BigDecimal minOrderPrice, BigDecimal maxOrderPrice, BigDecimal deliveryCost) {
        this.postcode = postcode;
        this.deliveryDuration = deliveryDuration;
        this.minOrderPrice = minOrderPrice;
        this.maxOrderPrice = maxOrderPrice;
        this.deliveryCost = deliveryCost;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Duration getDeliveryDuration() {
        return deliveryDuration;
    }

    public void setDeliveryDuration(Duration deliveryDuration) {
        this.deliveryDuration = deliveryDuration;
    }

    public BigDecimal getMinOrderPrice() {
        return minOrderPrice;
    }

    public void setMinOrderPrice(BigDecimal minOrderPrice) {
        this.minOrderPrice = minOrderPrice;
    }

    public BigDecimal getMaxOrderPrice() {
        return maxOrderPrice;
    }

    public void setMaxOrderPrice(BigDecimal maxOrderPrice) {
        this.maxOrderPrice = maxOrderPrice;
    }

    public BigDecimal getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(BigDecimal deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delivery delivery = (Delivery) o;
        return Objects.equals(id, delivery.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
