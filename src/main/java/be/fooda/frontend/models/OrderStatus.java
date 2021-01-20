package be.fooda.frontend.models;

public enum OrderStatus {

    PROCESSING_PARENT("processing"),
    PROCESSING_BEING_COOKED("processing the chief is cooking"),
    ON_DELIVERY_AND_PAYED("The order is delivered and payed"),
    ON_DELIVERY_AND_NOT_PAYED("The order is delivered and waiting for payment"),
    AWAITING_FOR_PAYMENT("Awaiting payment – stock is reduced, but you need to confirm payment"),
    PROCESSING_PAYED("The order is payed"),
    PAYMENT_FAILED("Payment failed or was declined "),
    COMPLETED("processing completed thanks for using Fooda,... "),
    CANCELED(" Canceled by an admin or the customer"),
    REFUNDED("Refunded by an admin");

    private  String value;


    OrderStatus(String s) {

    }

    public String getValue() {
        return value;
    }
}
