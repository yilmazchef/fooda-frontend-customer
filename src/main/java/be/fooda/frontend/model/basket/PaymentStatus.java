package be.fooda.frontend.model.basket;

public enum PaymentStatus {
    ALL_PAID("All amount paid already"),
    PARTIALLY_PAID("Waiting partial payment"),
    NOT_PAID("Not paid yet"),
    CANCELLED("Payment cancelled");

    private final String value;

    PaymentStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}