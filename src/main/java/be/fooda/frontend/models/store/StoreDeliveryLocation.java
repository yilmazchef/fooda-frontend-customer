package be.fooda.frontend.models.store;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreDeliveryLocation {

    private Long id;


    private String postcode;


    private Double deliveryTime;


    private BigDecimal minOrderPrice;

    private BigDecimal maxOrderPrice;

    private BigDecimal deliveryCost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Double getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Double deliveryTime) {
        this.deliveryTime = deliveryTime;
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





}
