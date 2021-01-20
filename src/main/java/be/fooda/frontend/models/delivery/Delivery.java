package be.fooda.frontend.models.delivery;


import be.fooda.frontend.models.DeliveryStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import java.util.List;

public class Delivery {

    @JsonIgnore
    private Long id;

    private Long deliveryTrackingId;

    private Boolean isActive = Boolean.TRUE;

    private DeliveryStore store;

    private DeliveryOrder order;

    private DeliveryCustomer customer;

    private DeliveryPayment payment;

    private List<DeliveryProduct> products;

    private DeliveryCourier courier;

    private LocalDateTime creationDateTime;

    private LocalDateTime updatedDateTime;

    private LocalDateTime requestedDateTime;

    private LocalDateTime deliveredDateTime;

    private DeliveryStatus status;

    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDeliveryTrackingId() {
        return deliveryTrackingId;
    }

    public void setDeliveryTrackingId(Long deliveryTrackingId) {
        this.deliveryTrackingId = deliveryTrackingId;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public DeliveryStore getStore() {
        return store;
    }

    public void setStore(DeliveryStore store) {
        this.store = store;
    }

    public DeliveryOrder getOrder() {
        return order;
    }

    public void setOrder(DeliveryOrder order) {
        this.order = order;
    }

    public DeliveryCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(DeliveryCustomer customer) {
        this.customer = customer;
    }

    public DeliveryPayment getPayment() {
        return payment;
    }

    public void setPayment(DeliveryPayment payment) {
        this.payment = payment;
    }

    public List<DeliveryProduct> getProducts() {
        return products;
    }

    public void setProducts(List<DeliveryProduct> products) {
        this.products = products;
    }

    public DeliveryCourier getCourier() {
        return courier;
    }

    public void setCourier(DeliveryCourier courier) {
        this.courier = courier;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public LocalDateTime getUpdatedDateTime() {
        return updatedDateTime;
    }

    public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }

    public LocalDateTime getRequestedDateTime() {
        return requestedDateTime;
    }

    public void setRequestedDateTime(LocalDateTime requestedDateTime) {
        this.requestedDateTime = requestedDateTime;
    }

    public LocalDateTime getDeliveredDateTime() {
        return deliveredDateTime;
    }

    public void setDeliveredDateTime(LocalDateTime deliveredDateTime) {
        this.deliveredDateTime = deliveredDateTime;
    }

    public DeliveryStatus getStatus() {
        return status;
    }

    public void setStatus(DeliveryStatus status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
