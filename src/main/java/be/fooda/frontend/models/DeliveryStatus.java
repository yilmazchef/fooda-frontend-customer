package be.fooda.frontend.models;

public enum DeliveryStatus {
    ON_DELIVERY_PARENT("on delivery"),
    ON_DELIVERY_BEING_PREPARED("The order is preparing for service"),
    ON_DELIVERY_COURIER("The order delivered to courier"),
    ON_DELIVERY_ARRIVED("The courier arrived at the delivery location"),
    ON_DELIVERY_ADDRESS_VERIFY("The courier could not find the delivery location. Hence, he/she requested verification of delivery address"),
    ON_DELIVERY_SUCCESS("Your order has been delivered by courier");

    private String value;

    DeliveryStatus(String s) {
    }

    public String getValue() {
        return value;
    }
}
