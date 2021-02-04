package be.fooda.frontend.model.order;

import be.fooda.frontend.model.OrderStatus;
import be.fooda.frontend.model.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;


public class Order {

    @JsonIgnore
    private Long id;

    private Long orderTrackingId;

    private Boolean isActive = Boolean.TRUE;

    private OrderDelivery delivery;

    private OrderCustomer customer;

    private OrderStore store;

    private OrderStatus status = OrderStatus.PROCESSING_PARENT;

    private PaymentStatus paymentStatus = PaymentStatus.NOT_PAID;

    private String note;

    private LocalTime requiredTime;

    private LocalDate requiredDate;

    private LocalDateTime creationDateTime;

    private LocalDateTime updatedDateTime;

    private LocalTime deliveryTime;

    private LocalDate deliveryDate;

    private LocalDateTime paymentDateTime;

    private BigDecimal productsTotal;

    private BigDecimal taxTotal;

    private BigDecimal deliveryTotal;

    private BigDecimal priceTotal;

    private List<OrderProduct> products;

    private List<OrderPayment> payments;

    public Long getId() {
        return id;
    }

    public Long getOrderTrackingId() {
        return orderTrackingId;
    }

    public Boolean getActive() {
        return isActive;
    }

    public OrderDelivery getDelivery() {
        return delivery;
    }

    public OrderCustomer getCustomer() {
        return customer;
    }

    public OrderStore getStore() {
        return store;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public String getNote() {
        return note;
    }

    public LocalTime getRequiredTime() {
        return requiredTime;
    }

    public LocalDate getRequiredDate() {
        return requiredDate;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public LocalDateTime getUpdatedDateTime() {
        return updatedDateTime;
    }

    public LocalTime getDeliveryTime() {
        return deliveryTime;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public LocalDateTime getPaymentDateTime() {
        return paymentDateTime;
    }

    public BigDecimal getProductsTotal() {
        return productsTotal;
    }

    public BigDecimal getTaxTotal() {
        return taxTotal;
    }

    public BigDecimal getDeliveryTotal() {
        return deliveryTotal;
    }

    public BigDecimal getPriceTotal() {
        return priceTotal;
    }

    public List<OrderProduct> getProducts() {
        return products;
    }

    public List<OrderPayment> getPayments() {
        return payments;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrderTrackingId(Long orderTrackingId) {
        this.orderTrackingId = orderTrackingId;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public void setDelivery(OrderDelivery delivery) {
        this.delivery = delivery;
    }

    public void setCustomer(OrderCustomer customer) {
        this.customer = customer;
    }

    public void setStore(OrderStore store) {
        this.store = store;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setRequiredTime(LocalTime requiredTime) {
        this.requiredTime = requiredTime;
    }

    public void setRequiredDate(LocalDate requiredDate) {
        this.requiredDate = requiredDate;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }

    public void setDeliveryTime(LocalTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setPaymentDateTime(LocalDateTime paymentDateTime) {
        this.paymentDateTime = paymentDateTime;
    }

    public void setProductsTotal(BigDecimal productsTotal) {
        this.productsTotal = productsTotal;
    }

    public void setTaxTotal(BigDecimal taxTotal) {
        this.taxTotal = taxTotal;
    }

    public void setDeliveryTotal(BigDecimal deliveryTotal) {
        this.deliveryTotal = deliveryTotal;
    }

    public void setPriceTotal(BigDecimal priceTotal) {
        this.priceTotal = priceTotal;
    }

    public void setProducts(List<OrderProduct> products) {
        this.products = products;
    }

    public void setPayments(List<OrderPayment> payments) {
        this.payments = payments;
    }
}
