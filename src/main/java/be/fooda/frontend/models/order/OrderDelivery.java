package be.fooda.frontend.models.order;

import be.fooda.frontend.models.DeliveryStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;


public class OrderDelivery {

    @JsonIgnore
    private Long id;

    private Long externalDeliveryId;

     private BigDecimal cost;

    private DeliveryStatus status = DeliveryStatus.ON_DELIVERY_PARENT;

    public Long getId() {
        return id;
    }

    public Long getExternalDeliveryId() {
        return externalDeliveryId;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public DeliveryStatus getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setExternalDeliveryId(Long externalDeliveryId) {
        this.externalDeliveryId = externalDeliveryId;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public void setStatus(DeliveryStatus status) {
        this.status = status;
    }
}
